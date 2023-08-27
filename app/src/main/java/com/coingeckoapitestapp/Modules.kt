package com.coingeckoapitestapp

import com.coingeckoapitestapp.network.CryptoService
import com.coingeckoapitestapp.network.CryptoServiceImpl
import com.coingeckoapitestapp.repository.CryptoRepositoryImpl
import com.coingeckoapitestapp.viewModel.CryptoViewModel
import io.ktor.client.HttpClient
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.serialization.kotlinx.json.json
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModel = module {
    viewModel { CryptoViewModel(get()) }
}

val repositoryModule = module {
    single { CryptoRepositoryImpl(get()) }
}

val httpModule = module {
    getClientHttp()
}

val serviceModule = module {
    single { CryptoServiceImpl(get(), get()) }
}

val dispatcher = module {
    single { getDispatcherProvider() }
}

private fun getClientHttp(): HttpClient =
    HttpClient(Android) {
        install(Logging) {
            level = LogLevel.ALL
        }
        install(ContentNegotiation) {
            json()
        }
        install(HttpTimeout) {
            requestTimeoutMillis = 15000L
        }
    }

private fun getDispatcherProvider(): DispatcherProvider = DispatcherProviderAndroid()
