package com.budiyev.android.libdemoapp.news.ui.Home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.budiyev.android.libdemoapp.R
import com.bumptech.glide.Glide
import com.budiyev.android.libdemoapp.news.model.Article

class ArticleAdapter(private var articles: List<Article>?=null, private val onClickListener: ((item: Article) -> Unit?)? =null) :
    RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val title: TextView = itemView.findViewById(R.id.articleTitle)
        val date: TextView = itemView.findViewById(R.id.date)
        val byline: TextView = itemView.findViewById(R.id.byline)
        val source: TextView = itemView.findViewById(R.id.source)
        val image: ImageView = itemView.findViewById(R.id.articleImg)
    }

    fun updateData(data: List<Article>) {
        articles = data
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.article_item, parent, false)
        )

    }

    override fun getItemCount(): Int {
        return articles?.size ?: 0
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = articles?.get(position)
        holder.title.text = item?.title
        holder.byline.text = item?.byline
        holder.source.text = item?.source
        holder.date.text = item?.date
        Glide.with(holder.itemView.context).load(item?.thumbnailUrl).placeholder(R.color.gray).centerCrop()
            .into(holder.image)
        holder.itemView.setOnClickListener {
            onClickListener?.invoke(item!!)
        }
    }
}