package com.coingeckoapitestapp.repository

import com.coingeckoapitestapp.model.response.CryptoDataResponse
import com.coingeckoapitestapp.model.response.CryptoInfoResponse
import com.coingeckoapitestapp.network.CryptoService

class CryptoRepositoryImpl(
    private val cryptoService: CryptoService
) : CryptoRepository {

    override suspend fun getCryptoList(): List<CryptoInfoResponse> {
        return cryptoService.getCryptoList()
    }

    override suspend fun getCryptoData(id: String): CryptoDataResponse {
        return cryptoService.getCryptoData(id)
    }
}