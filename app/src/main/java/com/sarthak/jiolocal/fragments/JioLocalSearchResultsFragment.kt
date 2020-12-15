package com.sarthak.jiolocal.fragments

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.MapView
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.Marker
import com.google.android.gms.maps.model.MarkerOptions
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.adapters.JioLocalSearchResultsAdapter
import com.sarthak.jiolocal.dao.JioLocalSearchResultFloatingPointDao
import com.sarthak.jiolocal.dao.JioLocalSearchSuggestionDao
import com.sarthak.jiolocal.databinding.JiolocalSearchResultsFloatingPointRecyclerViewBinding
import com.sarthak.jiolocal.viewholders.JioLocalSearchResultsFloatingPointItemViewHolder.OnSearchResultFloatingPointItemClickListener
import com.sarthak.jiolocal.viewmodels.DummyViewModel

class JioLocalSearchResultsFragment(
    private val searchSuggestion: JioLocalSearchSuggestionDao
) : Fragment(), OnMapReadyCallback, OnSearchResultFloatingPointItemClickListener,
    GoogleMap.OnMarkerClickListener {

    private val TAG = "JioLocalSearchResultsFragment"
    private val LIST_LAYOUT = 1
    private val MAP_LAYOUT = 2
    private var CURRENT_LAYOUT = LIST_LAYOUT

    private lateinit var map: GoogleMap
    private lateinit var dummyViewModel: DummyViewModel
    private lateinit var searchResults: List<JioLocalSearchResultFloatingPointDao>
    private lateinit var jioLocalSearchResultsFloatingPointRecyclerViewBinding: JiolocalSearchResultsFloatingPointRecyclerViewBinding
    private lateinit var layoutToggleSwitch: LinearLayout
    private lateinit var layoutToggleImageView: ImageView
    private lateinit var layoutToggleTextView: TextView
    private lateinit var searchResultsRecyclerView: RecyclerView
    private lateinit var searchResultsMapView: MapView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        jioLocalSearchResultsFloatingPointRecyclerViewBinding = DataBindingUtil.inflate(
            inflater,
            R.layout.jiolocal_search_results_floating_point_recycler_view,
            container,
            false
        )
        init()
        return jioLocalSearchResultsFloatingPointRecyclerViewBinding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        searchResultsMapView.onCreate(savedInstanceState)
        searchResultsMapView.onResume()
        searchResultsMapView.getMapAsync(this)
    }

    override fun onMapReady(p0: GoogleMap?) {
        if (p0 != null) {
            map = p0
        }

        // TODO: 14-12-2020 : Move map to user location.

        if (this::searchResults.isInitialized) {
            addSearchResultsOnMap()
        }
    }

    override fun onFloatingPointItemClick(searchResultFloatingPoint: JioLocalSearchResultFloatingPointDao) {
        // TODO: 14-12-2020 : Start Floating Point Detail Fragment.
    }

    override fun onFloatingPointCallButtonClick(searchResultFloatingPoint: JioLocalSearchResultFloatingPointDao) {
        val callIntent = Intent(Intent.ACTION_DIAL)
        callIntent.data = Uri.parse("tel:" + searchResultFloatingPoint.floatingPointContactNumber)
        startActivity(callIntent)
    }

    override fun onFloatingPointBookAppointmentClick(searchResultFloatingPoint: JioLocalSearchResultFloatingPointDao) {
        // TODO: 14-12-2020 : Implement this method. (move to screen 15 -> xd)
    }

    override fun onMarkerClick(p0: Marker?): Boolean {
        val floatingPoint = p0?.tag as JioLocalSearchResultFloatingPointDao
        val floatingPointDialogFragment = JioLocalFloatingPointDialogFragment(floatingPoint)
        floatingPointDialogFragment.show(
            requireActivity().supportFragmentManager,
            "floatingPointDialog"
        )
        // TODO: 14-12-2020 : show floatingPointItemCard as popup over map.
        return true
    }

    private fun init() {
        layoutToggleSwitch =
            jioLocalSearchResultsFloatingPointRecyclerViewBinding.searchLayoutToggleButton
        layoutToggleImageView =
            jioLocalSearchResultsFloatingPointRecyclerViewBinding.searchLayoutToggleIcon
        layoutToggleTextView =
            jioLocalSearchResultsFloatingPointRecyclerViewBinding.searchLayoutToggleText
        searchResultsRecyclerView =
            jioLocalSearchResultsFloatingPointRecyclerViewBinding.searchResultsListLayout
        searchResultsMapView =
            jioLocalSearchResultsFloatingPointRecyclerViewBinding.searchResultsMapLayout
        initViews()
    }

    private fun initViews() {
        dummyViewModel = ViewModelProvider(this, ViewModelProvider.NewInstanceFactory()).get(
            DummyViewModel::class.java
        )

        searchResults = dummyViewModel.getSearchResults(searchSuggestion.title)
        jioLocalSearchResultsFloatingPointRecyclerViewBinding.resultCount =
            "${searchResults.size} Results"
        searchResultsRecyclerView.layoutManager = LinearLayoutManager(context)
        searchResultsRecyclerView.adapter = JioLocalSearchResultsAdapter(searchResults, this)

        initListeners()
    }

    private fun initListeners() {
        layoutToggleSwitch.setOnClickListener {
            when (CURRENT_LAYOUT) {
                MAP_LAYOUT -> switchToListLayout()
                LIST_LAYOUT -> switchToMapLayout()
            }
        }
    }

    private fun switchToMapLayout() {
        if (!this::searchResults.isInitialized) {
            searchResults = dummyViewModel.getSearchResults(searchSuggestion.title)
            addSearchResultsOnMap()
        }

        layoutToggleTextView.text = "List view"
        layoutToggleImageView.setImageResource(R.drawable.ic_baseline_format_list_bulleted_24)

        searchResultsRecyclerView.visibility = View.GONE
        searchResultsMapView.visibility = View.VISIBLE
        CURRENT_LAYOUT = MAP_LAYOUT
    }

    private fun switchToListLayout() {
        layoutToggleTextView.text = "Map view"
        layoutToggleImageView.setImageResource(R.drawable.top_bar_location_icon)

        searchResultsRecyclerView.visibility = View.VISIBLE
        searchResultsMapView.visibility = View.GONE
        CURRENT_LAYOUT = LIST_LAYOUT
    }

    private fun addSearchResultsOnMap() {
        map.clear()
        searchResults.forEach { floatingPoint ->
            val markerOptions = MarkerOptions()
                .position(LatLng(floatingPoint.floatingPointLatitude,floatingPoint.floatingPointLongitude))
                .title(floatingPoint.floatingPointTitle)
            val marker = map.addMarker(markerOptions)
            marker.tag = floatingPoint
        }
    }
}