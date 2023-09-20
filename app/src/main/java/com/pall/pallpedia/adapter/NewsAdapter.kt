package com.pall.pallpedia.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.pall.pallpedia.data.ArticlesItem
import com.pall.pallpedia.databinding.ItemNewsBinding
import com.squareup.picasso.Picasso

class NewsAdapter : RecyclerView.Adapter<NewsAdapter.MyViewHolder>() {
    private val listNews = ArrayList<ArticlesItem>()

    fun setData(list: List<ArticlesItem>?) {
        if (list == null) return
        listNews.clear()
        listNews.addAll(list)
    }

    inner class MyViewHolder(val binding: ItemNewsBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = MyViewHolder(
        ItemNewsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
    )

    override fun getItemCount() = listNews.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val data = listNews[position]
        holder.binding.apply {
            itemTitle.text = data.title
            itemDate.text = data.publishedAt
            Picasso.get().load(data.urlToImage).into(itemImage)
        }
    }
}