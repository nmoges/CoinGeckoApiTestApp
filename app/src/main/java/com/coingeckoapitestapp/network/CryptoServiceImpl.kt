package com.coingeckoapitestapp.network

import com.coingeckoapitestapp.model.response.CryptoDataResponse
import com.coingeckoapitestapp.model.response.CryptoInfoResponse
import io.ktor.client.call.body
import io.ktor.client.request.get
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class CryptoServiceImpl : CryptoService {

    override suspend fun getCryptoList(): List<CryptoInfoResponse> =
        withContext(Dispatchers.IO) {
            CryptoHttpClient.client.get(ApiRoutes.LIST_COINS).body()
        }

    override suspend fun getCryptoData(id: String): CryptoDataResponse {
       return  withContext(Dispatchers.IO) {
            CryptoHttpClient.client.get("${ApiRoutes.ID_COIN}$id").body()
        }
    }
}