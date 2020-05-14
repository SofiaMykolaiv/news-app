package com.example.news_app.presentation.favourite

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_favourite.*
import org.koin.android.ext.android.inject

class FavouriteFragment : BaseFragment<FavouriteViewModel>() {

    companion object {
        fun newInstance() = FavouriteFragment()
    }

    override val viewModel by inject<FavouriteViewModel>()

    override fun getLayoutRes() = R.layout.fragment_favourite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }
}