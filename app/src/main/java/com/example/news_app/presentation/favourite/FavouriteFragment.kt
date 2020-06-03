package com.example.news_app.presentation.favourite

import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.news_app.R
import com.example.news_app.presentation.adapter.FavoriteAdapter
import com.example.news_app.presentation.base.BaseFragment
import com.example.news_app.presentation.mapper.mapFavouriteToArticleModel
import com.example.news_app.presentation.mapper.mapSearchToArticleModel
import com.example.news_app.presentation.model.FavouriteModel
import com.example.news_app.presentation.newsdetails.NewsDetailsFragment
import kotlinx.android.synthetic.main.fragment_favourite.*
import org.koin.android.ext.android.inject

class FavouriteFragment : BaseFragment<FavouriteViewModel>(), FavoriteClickListener {

    private lateinit var favouriteAdapter: FavoriteAdapter

    companion object {
        fun newInstance() = FavouriteFragment()
    }

    override val viewModel by inject<FavouriteViewModel>()

    override fun getLayoutRes() = R.layout.fragment_favourite

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        setAdapter()

        viewModel.loadFavouriteListDatabase()

        viewModel.favouriteLiveData.observe(viewLifecycleOwner, Observer { list ->
            favouriteAdapter.setList(list)
        })
    }

    private fun setAdapter() {
        favouriteAdapter = FavoriteAdapter(this)
        recycler_view.layoutManager = LinearLayoutManager(activity)
        recycler_view.adapter = favouriteAdapter
    }

    override fun onItemClick(favouriteModel: FavouriteModel) {
        val articleModel = mapFavouriteToArticleModel(favouriteModel)
        parentFragmentManager
            .beginTransaction()
            .replace(R.id.fragment_nav_host, NewsDetailsFragment.newInstance(articleModel.title!!))
            .commit()
    }
}