package com.droidcba.TestHomeWork

import android.app.Application
import com.droidcba.TestHomeWork.di.AppModule
import com.droidcba.TestHomeWork.di.news.DaggerNewsComponent
import com.droidcba.TestHomeWork.di.news.NewsComponent

class RedditApp : Application() {

    companion object {
        lateinit var newsComponent: NewsComponent
    }

    override fun onCreate() {
        super.onCreate()
        newsComponent = DaggerNewsComponent.builder()
                .appModule(AppModule(this))
                //.newsModule(NewsModule()) Module with empty constructor is implicitly created by dagger.
                .build()
    }
}