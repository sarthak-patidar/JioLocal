package com.sarthak.jiolocal

import com.sarthak.jiolocal.dao.RecentSearchDao
import com.sarthak.jiolocal.dao.SearchResultDao

class DummyRepository {

    fun getRecentSearches() : List<RecentSearchDao> {
        val recentSearches = ArrayList<RecentSearchDao>()
        recentSearches.add(RecentSearchDao("Back Massage", "Service", 42))
        recentSearches.add(RecentSearchDao("Salon For Women", "Category", 10))
        recentSearches.add(RecentSearchDao("Yoga Centre", "Category", 12))
        recentSearches.add(RecentSearchDao("Waxing", "Service", 25))
        return recentSearches
    }

    fun getSearchResults(input: String) : List<SearchResultDao> {
        val searchResults =  ArrayList<SearchResultDao>()
        searchResults.add(SearchResultDao("Spa Centres Near Me", "Category"))
        searchResults.add(SearchResultDao("Spa Centres", "Category"))
        searchResults.add(SearchResultDao("Spas-Men", "Category"))
        searchResults.add(SearchResultDao("Spas-24 Hours", "Category"))
        searchResults.add(SearchResultDao("Spas-Women", "Category"))
        return searchResults
    }
}