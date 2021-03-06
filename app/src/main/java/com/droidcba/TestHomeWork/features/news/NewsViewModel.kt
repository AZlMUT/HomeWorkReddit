package com.droidcba.TestHomeWork.features.news

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import com.droidcba.TestHomeWork.api.NewsAPI
import com.droidcba.TestHomeWork.api.RedditNewsResponse
import com.droidcba.TestHomeWork.commons.RedditNews
import com.droidcba.TestHomeWork.commons.RedditNewsItem
import kotlinx.coroutines.experimental.launch
import javax.inject.Inject
import kotlin.coroutines.experimental.CoroutineContext

class NewsViewModel @Inject constructor(
        private val api: NewsAPI,
        private val coroutineContext: CoroutineContext) : ViewModel() {

    val newsState: MutableLiveData<NewsState> = MutableLiveData()

    fun fetchNews(after: String, limit: String = "10") = launch(coroutineContext) {
        try {
            val result = api.getNews(after, limit).await()
            val news = process(result)
            newsState.postValue(NewsState.Success(news))
        } catch (e: Throwable) {
            newsState.postValue(NewsState.Error(e.message))
        }
    }

    private fun process(response: RedditNewsResponse): RedditNews {
        val dataResponse = response.data
        val news = dataResponse.children.map {
            val item = it.data
            RedditNewsItem(item.author, item.title, item.num_comments,
                    item.created, item.thumbnail, item.url)
        }
        return RedditNews(
                dataResponse.after.orEmpty(),
                dataResponse.before.orEmpty(),
                news)
    }
}