package com.coingeckoapitestapp

import com.coingeckoapitestapp.network.CryptoService
import com.coingeckoapitestapp.network.CryptoServiceImpl
import com.coingeckoapitestapp.repository.CryptoRepository
import com.coingeckoapitestapp.repository.CryptoRepositoryImpl
import com.coingeckoapitestapp.ui.screens.CryptoListScreenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.core.module.Module
import org.koin.dsl.module


val repositoryModule = module {
    single<CryptoRepository> { CryptoRepositoryImpl(get()) }
}

val viewModelModule = module {
    viewModel { CryptoListScreenViewModel(get()) }
}

val serviceModule = module {
    single<CryptoService> { CryptoServiceImpl() }
}

var listModules: MutableList<Module> = mutableListOf(
    viewModelModule,
    repositoryModule,
    serviceModule
)
