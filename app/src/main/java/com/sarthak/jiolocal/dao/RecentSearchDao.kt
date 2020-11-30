package com.sarthak.jiolocal.dao

class RecentSearchDao(val title : String, val category: String, private val offerCount: Int) {

    val offerString = "$offerCount Results with offers."
}