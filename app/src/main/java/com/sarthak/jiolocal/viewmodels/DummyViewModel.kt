package com.sarthak.jiolocal.viewmodels

import androidx.lifecycle.ViewModel
import com.sarthak.jiolocal.DummyRepository
import com.sarthak.jiolocal.dao.JioLocalRecentSearchDao
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao

class DummyViewModel() : ViewModel() {

    private val repository = DummyRepository()

    fun getRecentSearches() : List<JioLocalRecentSearchDao> {
        return repository.getRecentSearches()
    }

    fun getSearchSuggestions(input: String) : List<JioLocalSearchSuggestionDao> {
        return repository.getSearchSuggestions(input)
    }

}