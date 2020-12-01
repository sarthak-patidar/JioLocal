package com.sarthak.jiolocal

import com.sarthak.jiolocal.dao.RecentSearchDao
import com.sarthak.jiolocal.dao.SearchSuggestionDao

class DummyRepository {

    fun getRecentSearches() : List<RecentSearchDao> {
        val recentSearches = ArrayList<RecentSearchDao>()
        recentSearches.add(RecentSearchDao("Back Massage", "Service", 42))
        recentSearches.add(RecentSearchDao("Salon For Women", "Category", 10))
        recentSearches.add(RecentSearchDao("Yoga Centre", "Category", 12))
        recentSearches.add(RecentSearchDao("Waxing", "Service", 25))
        return recentSearches
    }

    fun getSearchResults(input: String) : List<SearchSuggestionDao> {
        val searchResults =  ArrayList<SearchSuggestionDao>()
        searchResults.add(SearchSuggestionDao("Spa Centres Near Me", "Category"))
        searchResults.add(SearchSuggestionDao("Spa Centres", "Category"))
        searchResults.add(SearchSuggestionDao("Spas-Men", "Category"))
        searchResults.add(SearchSuggestionDao("Spas-24 Hours", "Category"))
        searchResults.add(SearchSuggestionDao("Spas-Women", "Category"))
        return searchResults
    }
}