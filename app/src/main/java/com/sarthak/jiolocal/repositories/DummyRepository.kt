package com.sarthak.jiolocal.repositories

import com.sarthak.jiolocal.datamodels.JioLocalRecentSearchDao
import com.sarthak.jiolocal.datamodels.JioLocalSearchResultFloatingPointDao
import com.sarthak.jiolocal.datamodels.JioLocalSearchSuggestionDao

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

    fun getSearchResults(input: String): List<JioLocalSearchResultFloatingPointDao> {
        val searchResults = ArrayList<JioLocalSearchResultFloatingPointDao>()

        searchResults.add(JioLocalSearchResultFloatingPointDao("5f4fc461fbbaf20001dd4d86",
            "Makme Salon",
            618,
            "https://fpimages.withfloats.com/actual/5f6cef4dffad2b0794cdda70.jpg",
            "80, Nandanvan Society, Gurudwara Marg, Sector 17, Nerul, Thane",
            19.033316,
            73.023834,
            true,
            4f,
            1,
            2,
            true,
            9977943744
        ))

        searchResults.add(JioLocalSearchResultFloatingPointDao("5f4sc461fbbaf20001dd4d86",
            "Simon's Salon & Spa",
            100,
            "https://fpimages.withfloats.com/actual/5f6cef4dffad2b0794cdda70.jpg",
            "18, Nandanvan Society, Gurudwara Marg, Sector 17, Nerul, Thane",
            19.083316,
            73.033834,
            false,
            4f,
            1,
            2,
            true,
            9977943744
        ))

        searchResults.add(JioLocalSearchResultFloatingPointDao("5f4sc461fbbaf20001dd4d86",
            "Gunjan's Salon & Spa",
            100,
            "https://fpimages.withfloats.com/actual/5f6cef4dffad2b0794cdda70.jpg",
            "18, Nandanvan Society, Gurudwara Marg, Sector 17, Nerul, Thane",
            19.083316,
            73.033834,
            true,
            4f,
            1,
            2,
            false,
            8435882403
        ))

        return searchResults
    }
}