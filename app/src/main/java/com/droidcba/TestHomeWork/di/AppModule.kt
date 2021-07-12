package com.droidcba.TestHomeWork.di

import android.app.Application
import android.content.Context
import com.droidcba.TestHomeWork.RedditApp
import dagger.Module
import dagger.Provides
import kotlinx.coroutines.experimental.CommonPool
import javax.inject.Singleton
import kotlin.coroutines.experimental.CoroutineContext

@Module
class AppModule(val app: RedditApp) {

    @Provides
    @Singleton
    fun provideContext(): Context = app

    @Provides
    @Singleton
    fun provideApplication(): Application = app

    @Provides
    fun provideCoroutineContext(): CoroutineContext = CommonPool
}
