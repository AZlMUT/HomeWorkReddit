package com.droidcba.TestHomeWork.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.droidcba.TestHomeWork.R
import com.droidcba.TestHomeWork.commons.RedditNewsItem
import com.droidcba.TestHomeWork.commons.adapter.ViewType
import com.droidcba.TestHomeWork.commons.adapter.ViewTypeDelegateAdapter
import com.droidcba.TestHomeWork.commons.extensions.getFriendlyTime
import com.droidcba.TestHomeWork.commons.extensions.inflate
import com.droidcba.TestHomeWork.commons.extensions.loadImg
import kotlinx.android.synthetic.main.news_item.view.*

class NewsDelegateAdapter(val viewActions: onViewSelectedListener) : ViewTypeDelegateAdapter {

    interface onViewSelectedListener {
        fun onItemSelected(url: String?)
    }

    override fun onCreateViewHolder(parent: ViewGroup): RecyclerView.ViewHolder {
        return NewsViewHolder(parent)
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
        holder as NewsViewHolder
        holder.bind(item as RedditNewsItem)
    }

    inner class NewsViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item)) {

        private val imgThumbnail = itemView.img_thumbnail
        private val description = itemView.description
        private val author = itemView.author
        private val comments = itemView.comments
        private val time = itemView.time
        private val title = itemView.title

        fun bind(item: RedditNewsItem) {
            imgThumbnail.loadImg(item.thumbnail)
            description.text = item.title
            author.text = "Автор: ${item.author}"
            comments.text = "Коментариев: ${item.numComments}"
            time.text = item.created.getFriendlyTime()
            var mytitle = item.title.padEnd(15,'_').substring(0,10) + "..."
            while(mytitle.indexOf("__")>=0) mytitle.replace("__","_")
            title.text = mytitle

            super.itemView.setOnClickListener { viewActions.onItemSelected(item.url)}
        }
    }
}