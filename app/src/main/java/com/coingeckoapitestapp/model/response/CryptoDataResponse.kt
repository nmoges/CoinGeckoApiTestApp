package com.coingeckoapitestapp.model.response

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
class CryptoDataResponse(
    @SerialName("id") val id: String,
    @SerialName("symbol") val symbol: String,
    @SerialName("name") val name: String,
    @SerialName("image") val images: CryptoImages
)

@Serializable
data class CryptoImages(
    @SerialName("thumb") val thumbImgUrl: String,
    @SerialName("small") val smallImgUrl: String,
    @SerialName("large") val largeImgUrl: String
)