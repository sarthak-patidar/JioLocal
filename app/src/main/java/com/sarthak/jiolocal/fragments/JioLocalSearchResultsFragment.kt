package com.sarthak.jiolocal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.RecyclerView
import com.sarthak.jiolocal.R

class JioLocalSearchResultsFragment : Fragment() {

    private val TAG = "JioLocalSearchResultsFragment"
    private val MAP_LAYOUT = 2
    private val LIST_LAYOUT = 1
    private var CURRENT_LAYOUT = LIST_LAYOUT

    private lateinit var layoutToggleSwitch : LinearLayout
    private lateinit var layoutToggleImageView : ImageView
    private lateinit var layoutToggleTextView : TextView
    private lateinit var searchResultsList : RecyclerView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.jio_local_search_result_filter_recycler_view, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        layoutToggleSwitch = activity!!.findViewById(R.id.search_layout_toggle_button)
        layoutToggleImageView = activity!!.findViewById(R.id.search_layout_toggle_icon)
        layoutToggleTextView = activity!!.findViewById(R.id.search_layout_toggle_text)
        searchResultsList = activity!!.findViewById(R.id.search_list_layout_container)

        layoutToggleSwitch.setOnClickListener {
            when (CURRENT_LAYOUT) {
                MAP_LAYOUT -> switchToListLayout()
                LIST_LAYOUT -> switchToMapLayout()
            }
        }
    }

    private fun switchToMapLayout() {
        searchResultsList.visibility = View.GONE

        CURRENT_LAYOUT = MAP_LAYOUT
        //todo : add map fragment and mark search results on map
    }

    private fun switchToListLayout() {
        searchResultsList.visibility = View.VISIBLE
        CURRENT_LAYOUT = LIST_LAYOUT
        // todo : hide mapFragment
    }
}