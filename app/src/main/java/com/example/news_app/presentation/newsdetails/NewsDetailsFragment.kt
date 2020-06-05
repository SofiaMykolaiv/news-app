package com.example.news_app.presentation.newsdetails

import android.os.Bundle
import androidx.lifecycle.Observer
import com.example.news_app.R
import com.example.news_app.presentation.base.BaseFragment
import com.example.news_app.presentation.model.ArticleModel
import com.example.news_app.utils.loadImageUrl
import com.example.news_app.utils.showSimpleErrorDialog
import kotlinx.android.synthetic.main.fragment_news_details.*
import org.koin.android.ext.android.inject

class NewsDetailsFragment : BaseFragment<NewsDetailsViewModel>() {

    companion object {
        private const val KEY_TITLE = "key_title"
        private const val KEY_MODEL = "key_model"

        fun newInstance(articleTitle: String) = NewsDetailsFragment().apply {
            arguments = Bundle().apply {
                putString(KEY_TITLE, articleTitle)
            }
        }

        fun newInstance(articleModel: ArticleModel) = NewsDetailsFragment().apply {
            arguments = Bundle().apply {
                putParcelable(KEY_MODEL, articleModel)
            }
        }
    }

    override val viewModel by inject<NewsDetailsViewModel>()

    override fun getLayoutRes() = R.layout.fragment_news_details

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        val articleTitle = arguments?.getString(KEY_TITLE)
        val articleModel = arguments?.getParcelable<ArticleModel>(KEY_MODEL)

        if (articleModel != null) {
            image_favourite.setOnClickListener {
                setIsFavourite(articleModel.title)
            }
            initView(articleModel)
        } else {
            image_favourite.setOnClickListener {
                setIsFavourite(articleTitle)
            }

            viewModel.getArticleFromDatabase(articleTitle)
        }

        viewModel.newsDetailsLiveData.observe(viewLifecycleOwner, Observer { article ->
            initView(article)
        })
        viewModel.loadingLiveData.observe(viewLifecycleOwner, Observer { isLoading ->
            setLoadingState(isLoading)
        })
        viewModel.errorMessageLiveData.observe(viewLifecycleOwner, Observer { exceptionMessage ->
            showSimpleErrorDialog(context, null, exceptionMessage, null, null)
        })
        viewModel.favouriteLiveData.observe(viewLifecycleOwner, Observer { isFavourite ->
            if (isFavourite == true) {
                image_favourite.setImageDrawable(resources.getDrawable(R.drawable.ic_like, null))
            } else {
                image_favourite.setImageDrawable(resources.getDrawable(R.drawable.ic_dislike, null))
            }
        })
    }

    private fun initView(articleModel: ArticleModel) = articleModel.let { model ->
        image_news.loadImageUrl(url = model.urlToImage)
        text_author.text = model.author
        text_title.text = model.title
        text_website.text = model.urlToWebsite
        text_published_at.text = model.publishedAt
        text_content.text = model.description

        if (articleModel.isFavourite == true) {
            image_favourite.setImageDrawable(resources.getDrawable(R.drawable.ic_like, null))
        } else {
            image_favourite.setImageDrawable(resources.getDrawable(R.drawable.ic_dislike, null))
        }
    }

    private fun setIsFavourite(title: String?) {
        viewModel.setIsFavourite(title)
    }
}