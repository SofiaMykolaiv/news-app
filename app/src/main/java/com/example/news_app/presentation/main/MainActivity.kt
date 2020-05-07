package com.example.news_app.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.news_app.R
import com.example.news_app.presentation.home.HomeFragment
import com.google.android.material.bottomnavigation.LabelVisibilityMode
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_nav_host, HomeFragment.newInstance())
            .commit()

//        bottom_navigation.selectedItemId = R.id.home_fragment
//        bottom_navigation.labelVisibilityMode = LabelVisibilityMode.LABEL_VISIBILITY_LABELED
//        bottom_navigation.setOnNavigationItemSelectedListener { item ->
//            when (item.itemId) {
//                R.id.home_fragment -> {
//                    changeContainerFragment(HomeFragment.newInstance())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.search_fragment -> {
//                    changeContainerFragment(SearchFragment.newInstance())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                R.id.favourite_fragment -> {
//                    changeContainerFragment(FavouriteFragment.newInstance())
//                    return@setOnNavigationItemSelectedListener true
//                }
//                else -> false
//            }
        }
}
