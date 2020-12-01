package com.sarthak.jiolocal

import com.sarthak.jiolocal.dao.JioLocalRecentSearchDao
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao

class DummyRepository {

    fun getRecentSearches() : List<JioLocalRecentSearchDao> {
        val recentSearches = ArrayList<JioLocalRecentSearchDao>()
        recentSearches.add(JioLocalRecentSearchDao("Back Massage", "Service", 42))
        recentSearches.add(JioLocalRecentSearchDao("Salon For Women", "Category", 10))
        recentSearches.add(JioLocalRecentSearchDao("Yoga Centre", "Category", 12))
        recentSearches.add(JioLocalRecentSearchDao("Waxing", "Service", 25))
        return recentSearches
    }

    fun getSearchSuggestions(input: String) : List<JioLocalSearchSuggestionDao> {
        val searchResults =  ArrayList<JioLocalSearchSuggestionDao>()
        searchResults.add(JioLocalSearchSuggestionDao("Spa Centres Near Me", "Category"))
        searchResults.add(JioLocalSearchSuggestionDao("Spa Centres", "Category"))
        searchResults.add(JioLocalSearchSuggestionDao("Spas-Men", "Category"))
        searchResults.add(JioLocalSearchSuggestionDao("Spas-24 Hours", "Category"))
        searchResults.add(JioLocalSearchSuggestionDao("Spas-Women", "Category"))
        return searchResults
    }
}