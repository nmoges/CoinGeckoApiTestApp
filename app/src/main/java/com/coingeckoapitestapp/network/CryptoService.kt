package com.coingeckoapitestapp.network

import com.coingeckoapitestapp.model.response.CryptoDataResponse
import com.coingeckoapitestapp.model.response.CryptoInfoResponse

interface CryptoService {
    suspend fun getCryptoList():List<CryptoInfoResponse>
    suspend fun getCryptoData(id: String): CryptoDataResponse
}