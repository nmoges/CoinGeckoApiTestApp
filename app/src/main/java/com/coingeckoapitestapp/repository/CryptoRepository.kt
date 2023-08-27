package com.coingeckoapitestapp.repository

import com.coingeckoapitestapp.model.CryptoInfoResponse

interface CryptoRepository {
    suspend fun getCryptoList(): List<CryptoInfoResponse>
}