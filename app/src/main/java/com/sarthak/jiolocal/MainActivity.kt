package com.sarthak.jiolocal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sarthak.jiolocal.fragments.JioLocalSearchFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.jio_local_activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragmentContainer, JioLocalSearchFragment()).commit()
    }

}