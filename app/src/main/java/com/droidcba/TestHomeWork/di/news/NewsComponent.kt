package com.droidcba.TestHomeWork.di.news

import com.droidcba.TestHomeWork.di.AppModule
import com.droidcba.TestHomeWork.di.NetworkModule
import com.droidcba.TestHomeWork.features.news.NewsFragment
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [AppModule::class, NewsModule::class, NetworkModule::class])
interface NewsComponent {

    fun inject(newsFragment: NewsFragment)

}