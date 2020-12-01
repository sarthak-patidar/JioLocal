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
import com.sarthak.jiolocal.adapters.JioLocalRecentSearchesAdapter
import com.sarthak.jiolocal.adapters.JioLocalSearchSuggestionsAdapter
import com.sarthak.jiolocal.databinding.JioLocalSearchFragmentBinding
import com.sarthak.jiolocal.viewmodels.DummyViewModel

class JioLocalSearchFragment : Fragment() {

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
            .replace(R.id.location_searchFilter_header_container, JioLocalLocationUpdateFragment()).commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding : JioLocalSearchFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.jio_local_search_fragment, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        dummyViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DummyViewModel::class.java
        )
        locationFragmentContainer = activity!!.findViewById(R.id.location_searchFilter_header_container)
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
        recentSearchRecyclerView.adapter = JioLocalRecentSearchesAdapter(dummyViewModel.getRecentSearches())
        recentSearchRecyclerView.addItemDecoration(DividerItemDecoration(context, DividerItemDecoration.VERTICAL))

        toggleRecentSearchVisibility(if (areSearchResultsShown) View.GONE else View.VISIBLE)
    }

    private fun performSearch(input: String) {
        searchSuggestionsRecyclerContainer.adapter = JioLocalSearchSuggestionsAdapter(dummyViewModel.getSearchSuggestions(input))
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

    // todo: bind this function with onClick event on searchSuggestionItem
    private fun onSearchSuggestionClick(item : View) {
        activity!!.supportFragmentManager.beginTransaction()
            .add(R.id.search_results_container, JioLocalSearchResultsFragment())
            .commit()
    }
}