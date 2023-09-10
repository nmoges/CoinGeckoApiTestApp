package com.coingeckoapitestapp

enum class Crypto(val coinName: String) {
    AAVE("Aave"),
    BITCOIN("Bitcoin"),
    CARDANO("Cardano"),
    DOGECOIN("Dogecoin"),
    ETHEREUM("Ethereum"),
    LITECOIN("Litecoin"),
    POLYGON("Polygon"),
    SHIBA_INU("Shiba Inu"),
    SOLANA("Solana"),
    VECHAIN("VeChain");

    companion object {
        fun isInFilterList(name: String): Boolean {
            val crypto = values().find {
                it.coinName == name
            }
            crypto?.let {
                return true
            }
            return false
        }
    }
}

