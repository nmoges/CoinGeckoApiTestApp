package com.coingeckoapitestapp.network

import com.coingeckoapitestapp.model.CryptoInfoResponse

interface CryptoService {
    suspend fun getCryptoList():List<CryptoInfoResponse>
}