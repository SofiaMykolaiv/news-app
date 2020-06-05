package com.example.news_app.presentation.search

import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import com.example.news_app.presentation.mapper.mapSearchToArticleModel
import com.example.news_app.presentation.model.SearchArticleModel
import com.example.news_app.presentation.newsdetails.NewsDetailsFragment
import com.example.news_app.utils.hideKeyboard
import kotlinx.android.synthetic.main.fragment_search.*
import org.koin.android.ext.android.inject

class SearchFragment : BaseFragment<SearchViewModel>(), SearchArticleClickListener {

    private lateinit var searchAdapter: SearchAdapter

    companion object {
        fun newInstance() = SearchFragment()
    }

    override val viewModel by inject<SearchViewModel>()

    override fun getLayoutRes() = R.layout.fragment_search

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setAdapter()

        image_search.setOnClickListener {
            hideKeyboard()

            val searchText = edit_search.text.toString()

            if (searchText.isEmpty()) {
                Toast.makeText(context, "Enter search field first, please.", Toast.LENGTH_SHORT)
                    .show()
            } else {
                viewModel.getSearchArticleList(searchField = searchText)
            }
        }

        viewModel.searchArticleLiveData.observe(viewLifecycleOwner, Observer { list ->
            searchAdapter.setList(list)
        })
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            Toast.makeText(context, exceptionMessage, Toast.LENGTH_SHORT).show()
        })
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            setLoadingState(isLoading)
        })
    }

    private fun setAdapter() {
        searchAdapter = SearchAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = searchAdapter
    }

    override fun onItemClick(searchArticleModel: SearchArticleModel) {
        val articleModel = mapSearchToArticleModel(searchArticleModel)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_nav_host, NewsDetailsFragment.newInstance(articleModel))
            .commit()
    }
}