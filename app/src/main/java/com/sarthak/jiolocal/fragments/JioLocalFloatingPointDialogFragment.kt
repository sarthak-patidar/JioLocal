package com.sarthak.jiolocal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.datamodels.JioLocalSearchResultFloatingPointDao

class JioLocalFloatingPointDialogFragment : DialogFragment(){

    companion object {
        private const val FLOATING_POINT_ID_ARG_KEY = "floatingPointId"

        fun newInstance(floatingPoint: JioLocalSearchResultFloatingPointDao): JioLocalFloatingPointDialogFragment{
            val args = Bundle()
            args.putString(FLOATING_POINT_ID_ARG_KEY, floatingPoint.floatingPointId)

            val fragment = JioLocalFloatingPointDialogFragment()
            fragment.arguments = args
            return fragment
        }
    }

    private lateinit var floatingPointId: String

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        floatingPointId = arguments?.getString(FLOATING_POINT_ID_ARG_KEY, "").toString()
        return inflater.inflate(R.layout.jiolocal_floating_point_dialog, container, false)
    }

}