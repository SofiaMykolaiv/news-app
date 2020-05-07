package com.example.news_app.presentation.home

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import kotlinx.android.synthetic.main.fragment_home.*
import org.koin.android.ext.android.inject

class HomeFragment : BaseFragment<HomeViewModel>() {

    private lateinit var homeAdapter: HomeAdapter

    companion object {
        fun newInstance() = HomeFragment()
    }

    override val viewModel by inject<HomeViewModel>()

    override fun getLayoutRes() = R.layout.fragment_home

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setAdapter()
        viewModel.getArticleList()
        viewModel.articleLiveData.observe(viewLifecycleOwner, Observer {
            if (it.data!= null) {
                homeAdapter.setList(it.data)
            }
            if (it.error!= null) {
                // TODO: show error message
            }
        })
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter()
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = homeAdapter
    }
}