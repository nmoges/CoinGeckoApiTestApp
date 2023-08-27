package com.coingeckoapitestapp.network

import com.coingeckoapitestapp.model.CryptoInfoResponse
import io.ktor.client.HttpClient
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext

class CryptoServiceImpl(
    private val client: HttpClient,
    private val ioDispatcher: CoroutineDispatcher
): CryptoService {
    override suspend fun getCryptoList(): List<CryptoInfoResponse> = withContext(ioDispatcher) {
        client.get(ApiRoutes.LIST_COINS).body()
    }
}