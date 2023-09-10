package com.coingeckoapitestapp

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class CoinGeckoTestApp : Application() {

    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@CoinGeckoTestApp)
            modules(listModules)
        }
    }
}