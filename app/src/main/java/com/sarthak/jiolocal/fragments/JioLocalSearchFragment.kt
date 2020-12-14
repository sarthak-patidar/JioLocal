package com.sarthak.jiolocal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.ImageView
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
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao
import com.sarthak.jiolocal.databinding.JiolocalSearchFragmentBinding
import com.sarthak.jiolocal.viewholders.JioLocalSearchSuggestionViewHolder.OnSearchSuggestionClickListener
import com.sarthak.jiolocal.viewmodels.DummyViewModel

class JioLocalSearchFragment : Fragment(), OnSearchSuggestionClickListener {

    private var areSearchResultsShown = false

    private lateinit var jioLocalSearchFragmentBinding: JiolocalSearchFragmentBinding
    private lateinit var clearSearch: ImageView
    private lateinit var locationFragmentContainer: FragmentContainerView
    private lateinit var recentSearchRecyclerView: RecyclerView
    private lateinit var searchBox: EditText
    private lateinit var searchSuggestionsRecyclerContainer: RecyclerView
    private lateinit var dummyViewModel: DummyViewModel

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.location_searchFilter_header_container, JioLocalLocationUpdateFragment()).commit()
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        jioLocalSearchFragmentBinding = DataBindingUtil.inflate(
            inflater, R.layout.jiolocal_search_fragment, container, false)
        init()
        return jioLocalSearchFragmentBinding.root
    }

    private fun init() {
        dummyViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DummyViewModel::class.java
        )

        locationFragmentContainer = jioLocalSearchFragmentBinding.locationSearchFilterHeaderContainer
        recentSearchRecyclerView = jioLocalSearchFragmentBinding.recentSearchRecyclerContainer
        searchSuggestionsRecyclerContainer = jioLocalSearchFragmentBinding.searchSuggestionsRecyclerContainer
        searchBox = jioLocalSearchFragmentBinding.jiolocalSearchBox
        clearSearch = jioLocalSearchFragmentBinding.clearSearchText

        initViews()
    }

    private fun initViews() {
        initListeners()
        updateRecyclerViews()
    }

    private fun initListeners() {
        searchBox.doOnTextChanged { text, start, before, count ->
            if (text.toString() == "") {
                clearSearch.visibility = View.INVISIBLE
            } else {
                clearSearch.visibility = View.VISIBLE
            }

            if (count >= 3) {
                performSearch(text.toString())
            } else if (areSearchResultsShown) {
                toggleRecentSearchVisibility(View.VISIBLE)
            }
        }

        clearSearch.setOnClickListener {
            searchBox.text.clear()
            toggleRecentSearchVisibility(View.VISIBLE)
            jioLocalSearchFragmentBinding.searchResultsContainer.visibility = View.GONE
        }
    }

    override fun onSearchSuggestionClick(item: JioLocalSearchSuggestionDao) {
        // todo : put item variable in bundle and pass bundle to fragment instead of directly passing.
        jioLocalSearchFragmentBinding.searchResultsContainer.visibility = View.VISIBLE
        requireActivity().supportFragmentManager.beginTransaction()
            .add(R.id.search_results_container, JioLocalSearchResultsFragment(item))
            .commit()
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
        searchSuggestionsRecyclerContainer.adapter = JioLocalSearchSuggestionsAdapter(dummyViewModel.getSearchSuggestions(input), this)
        toggleRecentSearchVisibility(View.GONE)
    }

    private fun toggleRecentSearchVisibility(visibility: Int) {
        recentSearchRecyclerView.visibility = visibility
        jioLocalSearchFragmentBinding.jiolocalRecentSearchHeader.visibility = visibility

        searchSuggestionsRecyclerContainer.visibility = when (visibility) {
            View.VISIBLE -> View.GONE
            else -> View.VISIBLE
        }
        areSearchResultsShown = visibility != View.VISIBLE
    }
}