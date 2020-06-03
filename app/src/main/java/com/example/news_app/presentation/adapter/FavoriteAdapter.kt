package com.example.news_app.presentation.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.news_app.databinding.ListItemFavoriteBinding
import com.example.news_app.presentation.favourite.FavoriteClickListener
import com.example.news_app.presentation.model.FavouriteModel
import com.example.news_app.utils.loadImageUrl

class FavoriteAdapter(listener: FavoriteClickListener) : RecyclerView.Adapter<FavoriteAdapter.ViewHolder>() {

    private val articleClickListener = listener
    private var articleList = arrayListOf<FavouriteModel>()

    fun setList(list: List<FavouriteModel>) {
        articleList.clear()
        articleList.addAll(list)
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int = articleList.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val holder = ListItemFavoriteBinding.inflate(inflater, parent, false)
        return ViewHolder(holder)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(articleList[position], articleClickListener)
    }

    class ViewHolder(private val binding: ListItemFavoriteBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(model: FavouriteModel, listener: FavoriteClickListener) {
            binding.model = model
            binding.clickListener = listener
            binding.articleImage.loadImageUrl(model.urlToImage)
        }
    }
}
