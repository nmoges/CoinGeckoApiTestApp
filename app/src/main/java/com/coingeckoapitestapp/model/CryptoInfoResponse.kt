package com.coingeckoapitestapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoInfoResponse(
    val id: String,
    val symbol: String,
    val name: String
)