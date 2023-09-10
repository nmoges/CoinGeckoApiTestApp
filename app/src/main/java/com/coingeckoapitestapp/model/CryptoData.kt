package com.coingeckoapitestapp.model

import kotlinx.serialization.Serializable

@Serializable
data class CryptoData(
    val id: String,
    val symbol: String,
    val name: String
)
