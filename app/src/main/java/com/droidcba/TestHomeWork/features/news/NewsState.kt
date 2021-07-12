package com.droidcba.TestHomeWork.features.news

import com.droidcba.TestHomeWork.commons.RedditNews

sealed class NewsState {
    class Success(val redditNews: RedditNews) : NewsState()
    class Error(val message: String?) : NewsState()
}