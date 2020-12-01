package com.sarthak.jiolocal.dao

class JioLocalRecentSearchDao(val title : String, val category: String, private val offerCount: Int) {

    val offerString = "$offerCount Results with offers."
}