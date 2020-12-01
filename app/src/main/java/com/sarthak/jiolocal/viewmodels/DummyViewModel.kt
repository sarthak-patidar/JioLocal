package com.sarthak.jiolocal.viewmodels

import androidx.lifecycle.ViewModel
import com.sarthak.jiolocal.DummyRepository
import com.sarthak.jiolocal.dao.RecentSearchDao
import com.sarthak.jiolocal.dao.SearchSuggestionDao

class DummyViewModel() : ViewModel() {

    private val repository = DummyRepository()

    fun getRecentSearches() : List<RecentSearchDao> {
        return repository.getRecentSearches()
    }

    fun getSearchResults(input: String) : List<SearchSuggestionDao> {
        return repository.getSearchResults(input)
    }

}