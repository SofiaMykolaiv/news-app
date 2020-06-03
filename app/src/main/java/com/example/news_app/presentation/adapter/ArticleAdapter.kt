package com.example.news_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.ListItemArticleBinding
import com.example.news_app.presentation.home.ArticleClickListener
import com.example.news_app.presentation.model.ArticleModel
import com.example.news_app.utils.loadImageUrl

class ArticleAdapter(listener: ArticleClickListener) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    private val articleClickListener = listener
    private var articleList = arrayListOf<ArticleModel>()

    fun setList(list: List<ArticleModel>) {
        articleList.clear()
        articleList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = articleList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ListItemArticleBinding.inflate(inflater, parent, false)
        return ViewHolder(
            holder
        )
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position], articleClickListener)
    }

    class ViewHolder(private val binding: ListItemArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: ArticleModel, listener: ArticleClickListener) {
            binding.model = model
            binding.clickListener = listener
            binding.articleImage.loadImageUrl(model.urlToImage)
        }
    }
}
