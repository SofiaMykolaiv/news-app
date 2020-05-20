package com.example.news_app.presentation.home

import android.os.Bundle
import android.view.View
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import com.example.news_app.utils.showSimpleErrorDialog
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

        viewModel.articleLiveData.observe(viewLifecycleOwner, Observer { list ->
            homeAdapter.setList(list)
        })
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            showSimpleErrorDialog(context, null, exceptionMessage, null, null)
        })
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            setLoadingState(isLoading)
        })
    }

    private fun setAdapter() {
        homeAdapter = HomeAdapter()
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = homeAdapter
    }
}