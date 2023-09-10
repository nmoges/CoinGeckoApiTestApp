package com.coingeckoapitestapp

import com.coingeckoapitestapp.network.CryptoService
import com.coingeckoapitestapp.network.CryptoServiceImpl
import com.coingeckoapitestapp.repository.CryptoRepository
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
import org.koin.core.module.Module
import org.koin.dsl.module


val repositoryModule = module {
    single<CryptoRepository> { CryptoRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { CryptoViewModel(get()) }
}

val serviceModule = module {
    single<CryptoService> { CryptoServiceImpl() }
}

var listModules: MutableList<Module> = mutableListOf(
    viewModelModule,
    repositoryModule,
    serviceModule
)
