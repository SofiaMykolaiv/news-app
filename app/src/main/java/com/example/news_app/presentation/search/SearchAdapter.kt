package com.example.news_app.presentation.search

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.ListItemSearchArticleBinding
import com.example.news_app.presentation.model.SearchArticleModel
import com.example.news_app.utils.loadImageUrl

class SearchAdapter(listener: SearchArticleClickListener) :
    RecyclerView.Adapter<SearchAdapter.ViewHolder>() {

    private val searchArticleClickListener = listener
    private var articleList = arrayListOf<SearchArticleModel>()

    fun setList(list: List<SearchArticleModel>) {
        articleList.clear()
        articleList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = articleList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ListItemSearchArticleBinding.inflate(inflater, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position], searchArticleClickListener)
    }

    class ViewHolder(private val binding: ListItemSearchArticleBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: SearchArticleModel, listener: SearchArticleClickListener) {
            binding.model = model
            binding.clickListener = listener
            binding.articleImage.loadImageUrl(model.urlToImage)
        }
    }
}