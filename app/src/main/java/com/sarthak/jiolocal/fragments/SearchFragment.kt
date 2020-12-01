package com.sarthak.jiolocal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
import android.widget.LinearLayout
import androidx.core.widget.doOnTextChanged
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentContainerView
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.adapters.RecentSearchesAdapter
import com.sarthak.jiolocal.adapters.SearchSuggestionsAdapter
import com.sarthak.jiolocal.databinding.LocalSearchFragmentBinding
import com.sarthak.jiolocal.viewmodels.DummyViewModel

class SearchFragment : Fragment() {

    private var areSearchResultsShown = false

    private lateinit var clearSearch : ImageView
    private lateinit var locationFragmentContainer : FragmentContainerView
    private lateinit var recentSearchRecyclerView: RecyclerView
    private lateinit var searchBox : EditText
    private lateinit var searchSuggestionsRecyclerContainer: RecyclerView
    private lateinit var dummyViewModel: DummyViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        activity!!.supportFragmentManager.beginTransaction()
            .replace(R.id.location_header_container, LocationUpdateFragment()).commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : LocalSearchFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.local_search_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dummyViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DummyViewModel::class.java
        )
        locationFragmentContainer = activity!!.findViewById(R.id.location_header_container)
        recentSearchRecyclerView = activity!!.findViewById(R.id.recent_search_recycler_container)
        searchSuggestionsRecyclerContainer = activity!!.findViewById(R.id.search_suggestions_recycler_container)
        searchBox = activity!!.findViewById(R.id.jiolocal_search_box)
        clearSearch = activity!!.findViewById(R.id.clear_search_text)


        setListeners()
        updateRecyclerViews()
    }

    private fun setListeners() {
        searchBox.doOnTextChanged { text, start, before, count ->
            if (text.toString() == "") {
                clearSearch.visibility = View.INVISIBLE
            } else {
                clearSearch.visibility = View.VISIBLE
            }

            if(count == 3) {
                performSearch(text.toString())
            } else if (areSearchResultsShown && count < 3) {
                toggleRecentSearchVisibility(View.VISIBLE)
            }
        }

        clearSearch.setOnClickListener {
            searchBox.text.clear()
        }

    }

    private fun updateRecyclerViews() {
        searchSuggestionsRecyclerContainer.layoutManager = LinearLayoutManager(context)
        searchSuggestionsRecyclerContainer.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        recentSearchRecyclerView.layoutManager = LinearLayoutManager(context)
        recentSearchRecyclerView.adapter = RecentSearchesAdapter(dummyViewModel.getRecentSearches())
        recentSearchRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        toggleRecentSearchVisibility(if (areSearchResultsShown) View.GONE else View.VISIBLE)
    }

    private fun performSearch(input: String) {
        searchSuggestionsRecyclerContainer.adapter = SearchSuggestionsAdapter(dummyViewModel.getSearchResults(input))
        toggleRecentSearchVisibility(View.GONE)
    }

    private fun toggleRecentSearchVisibility(visibility: Int) {
        recentSearchRecyclerView.visibility = visibility
        activity!!.findViewById<LinearLayout>(R.id.jiolocal_recent_search_header).visibility = visibility

        searchSuggestionsRecyclerContainer.visibility = when (visibility) {
            View.VISIBLE -> View.GONE
            else -> View.VISIBLE
        }
        areSearchResultsShown = visibility != View.VISIBLE
    }
}