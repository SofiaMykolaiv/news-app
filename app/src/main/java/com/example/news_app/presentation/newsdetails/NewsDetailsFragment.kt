package com.example.news_app.presentation.newsdetails

import android.os.Bundle
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import com.example.news_app.presentation.model.ArticleModel
import com.example.news_app.utils.loadImageUrl
import kotlinx.android.synthetic.main.fragment_news_details.*
import org.koin.android.ext.android.inject

class NewsDetailsFragment : BaseFragment<NewsDetailsViewModel>() {

    companion object {
        private const val KEY_MODEL = "key_model"

        fun newInstance(model: ArticleModel) = NewsDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_MODEL, model)
            }
        }
    }

    override val viewModel by inject<NewsDetailsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_news_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val article = arguments?.getParcelable<ArticleModel>(KEY_MODEL)

        initView(articleModel = article)
    }

    private fun initView(articleModel: ArticleModel?) = articleModel?.let { model ->
        image_news.loadImageUrl(url = model.urlToImage)
        text_author.text = model.author
        text_title.text = model.title
        text_website.text = model.urlToWebsite
        text_published_at.text = model.publishedAt
        text_content.text = model.description
    }
}