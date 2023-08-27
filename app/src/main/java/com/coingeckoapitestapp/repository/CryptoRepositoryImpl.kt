package com.coingeckoapitestapp.repository

import com.coingeckoapitestapp.model.CryptoInfoResponse
import com.coingeckoapitestapp.network.CryptoService

class CryptoRepositoryImpl(private val cryptoService: CryptoService): CryptoRepository {
    override suspend fun getCryptoList(): List<CryptoInfoResponse> {
        return cryptoService.getCryptoList()
    }
}