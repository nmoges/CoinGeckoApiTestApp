package com.coingeckoapitestapp.network

import com.coingeckoapitestapp.model.CryptoInfoResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.engine.android.Android
import io.ktor.client.plugins.HttpTimeout
import io.ktor.client.plugins.contentnegotiation.ContentNegotiation
import io.ktor.client.plugins.logging.LogLevel
import io.ktor.client.plugins.logging.Logging
import io.ktor.client.request.get
import io.ktor.serialization.kotlinx.json.json
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoServiceImpl: CryptoService {

    override suspend fun getCryptoList(): List<CryptoInfoResponse> =
        withContext(Dispatchers.IO) {
            CryptoHttpClient.client.get(ApiRoutes.LIST_COINS).body()
        }

    private fun getHttpClient() = HttpClient(Android) {
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
}