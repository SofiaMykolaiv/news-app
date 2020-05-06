package com.example.news_app.presentation.home

import android.os.Bundle
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}