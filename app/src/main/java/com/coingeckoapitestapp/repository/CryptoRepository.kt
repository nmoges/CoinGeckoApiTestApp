package com.coingeckoapitestapp.repository

import com.coingeckoapitestapp.model.response.CryptoDataResponse
import com.coingeckoapitestapp.model.response.CryptoInfoResponse

interface CryptoRepository {
    suspend fun getCryptoList(): List<CryptoInfoResponse>
    suspend fun getCryptoData(id: String): CryptoDataResponse
}