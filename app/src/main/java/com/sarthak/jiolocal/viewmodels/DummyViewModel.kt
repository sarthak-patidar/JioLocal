package com.sarthak.jiolocal.viewmodels

import androidx.lifecycle.ViewModel
import com.sarthak.jiolocal.repositories.DummyRepository
import com.sarthak.jiolocal.datamodels.JioLocalRecentSearchDao
import com.sarthak.jiolocal.datamodels.JioLocalSearchResultFloatingPointDao
import com.sarthak.jiolocal.datamodels.JioLocalSearchSuggestionDao

class DummyViewModel() : ViewModel() {

    private val repository = DummyRepository()

    fun getRecentSearches() : List<JioLocalRecentSearchDao> {
        return repository.getRecentSearches()
    }

    fun getSearchSuggestions(input: String) : List<JioLocalSearchSuggestionDao> {
        return repository.getSearchSuggestions(input)
    }

    fun getSearchResults(input: String): List<JioLocalSearchResultFloatingPointDao> {
        return repository.getSearchResults(input)
    }

}