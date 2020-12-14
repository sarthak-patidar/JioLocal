package com.sarthak.jiolocal.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import com.sarthak.jiolocal.R
import com.sarthak.jiolocal.dao.JioLocalSearchResultFloatingPointDao

class JioLocalFloatingPointDialogFragment(
    private val floatingPoint: JioLocalSearchResultFloatingPointDao
) : DialogFragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        super.onCreateView(inflater, container, savedInstanceState)
        return inflater.inflate(R.layout.jiolocal_floating_point_dialog, container, false)
    }

}