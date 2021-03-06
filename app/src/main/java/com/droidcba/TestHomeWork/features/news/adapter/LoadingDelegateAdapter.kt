package com.droidcba.TestHomeWork.features.news.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import com.droidcba.TestHomeWork.commons.adapter.ViewType
import com.droidcba.TestHomeWork.commons.adapter.ViewTypeDelegateAdapter
import com.droidcba.TestHomeWork.R
import com.droidcba.TestHomeWork.commons.extensions.inflate

class LoadingDelegateAdapter : ViewTypeDelegateAdapter {

    override fun onCreateViewHolder(parent: ViewGroup) = LoadingViewHolder(parent)

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, item: ViewType) {
    }

    class LoadingViewHolder(parent: ViewGroup) : RecyclerView.ViewHolder(
            parent.inflate(R.layout.news_item_loading))
}