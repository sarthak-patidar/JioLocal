package com.sarthak.jiolocal.fragments

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.fragment.app.FragmentContainerView
import com.sarthak.jiolocal.R

class JioLocalLocationUpdateFragment : Fragment() {

    private val TAG = "LocationUpdateFragment"
    private lateinit  var fragmentContainer : FragmentContainerView

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        fragmentContainer = activity!!.findViewById(R.id.location_searchFilter_header_container) as FragmentContainerView
        return inflater.inflate(R.layout.jio_local_fragment_location, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        Log.e(TAG, "onViewCreated: clicked" )
        val layout = view.findViewById<ConstraintLayout>(R.id.locationHeader)
        // todo: add onClick listener to locationHeader to open update location popup.
//        layout.setOnClickListener {
//            //TODO(check if the layout is shown, if shown then do no proceed )
//            activity!!.supportFragmentManager.beginTransaction()
//                .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
//                .replace(fragmentContainer.id, LocationCaptureAndCheckDialog()).commit()
//        }
    }

}