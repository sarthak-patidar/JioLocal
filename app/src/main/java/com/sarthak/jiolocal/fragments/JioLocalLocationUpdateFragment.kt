package com.sarthak.jiolocal.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.FragmentContainerView
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.databinding.JiolocalFragmentLocationBinding

class JioLocalLocationUpdateFragment : Fragment() {

    private val TAG = "LocationUpdateFragment"
    private lateinit var fragmentContainer : FragmentContainerView
    private lateinit var jioLocalFragmentLocationBinding : JiolocalFragmentLocationBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        jioLocalFragmentLocationBinding = DataBindingUtil.inflate(
            inflater, R.layout.jiolocal_fragment_location, container, false
        )
        return jioLocalFragmentLocationBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        fragmentContainer = requireActivity().findViewById(R.id.location_header_container) as FragmentContainerView
        // todo: add onClick listener to locationHeader to open update location popup.
        //    val layout = view?.findViewById<ConstraintLayout>(R.id.locationHeader)
        //          layout.setOnClickListener {
        //              //todo : check if the layout is shown, if shown then do no proceed.
        //              activity!!.supportFragmentManager.beginTransaction()
        //                  .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN)
        //                  .replace(fragmentContainer.id, LocationCaptureAndCheckDialog()).commit()
        //          }
    }
}