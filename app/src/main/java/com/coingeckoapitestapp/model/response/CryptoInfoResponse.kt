package com.coingeckoapitestapp.model.response

import com.coingeckoapitestapp.model.CryptoData
import kotlinx.serialization.Serializable

@Serializable
data class CryptoInfoResponse(
    val id: String,
    val symbol: String,
    val name: String
)

fun CryptoInfoResponse.toCryptoData() = CryptoData(
    id = this.id,
    symbol = this.symbol,
    name = this.name,
)