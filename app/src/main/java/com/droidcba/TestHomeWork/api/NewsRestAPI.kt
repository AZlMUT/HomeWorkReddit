package com.droidcba.TestHomeWork.api

import com.droidcba.TestHomeWork.commons.Logger
import kotlinx.coroutines.experimental.Deferred
import retrofit2.Call
import javax.inject.Inject

class NewsRestAPI @Inject constructor(private val redditApi: RedditApi) : NewsAPI {

    override suspend fun getNews(after: String, limit: String): Deferred<RedditNewsResponse> {
        Logger.dt("calling Rest API")
        return redditApi.getDeferredTop(after, limit)
    }

    override fun getNewsOldApi(after: String, limit: String): Call<RedditNewsResponse> {
        return redditApi.getTop(after, limit)
    }
}