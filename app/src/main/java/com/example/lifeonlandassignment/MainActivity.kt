package com.example.lifeonlandassignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity: AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction().apply {
                setReorderingAllowed(true)
//                add(R.id.fragment_container, HomeFragment())
//                add(R.id.fragment_container, FavouriteFragment())
//                add(R.id.fragment_container, ProfileFragment())
                add(R.id.fragment_container, EventFragment())
                commit()
            }
        }
    }
}

