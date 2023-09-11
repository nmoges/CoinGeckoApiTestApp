package com.coingeckoapitestapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coingeckoapitestapp.Crypto
import com.coingeckoapitestapp.model.CryptoData
import com.coingeckoapitestapp.model.response.toCryptoData
import com.coingeckoapitestapp.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

// TODO : replace by use cases
class CryptoViewModel(
    private val cryptoRepository: CryptoRepository
) : ViewModel() {

    private val _listCryptoCoin = MutableStateFlow<List<CryptoData>>(mutableListOf())
    val listCryptoCoin: StateFlow<List<CryptoData>>
        get() = _listCryptoCoin

    fun getCryptoList() {
        viewModelScope.launch {
            val list: MutableList<CryptoData> = mutableListOf()
            cryptoRepository.getCryptoList().forEach {
                if (Crypto.isInFilterList(it.name)) {
                    list.add(it.toCryptoData())
                }
            }
            getCryptoData(list[0].id)
            _listCryptoCoin.value = list
        }
    }

    private fun getCryptoData(id: String) {
        viewModelScope.launch {
            val cryptoDataResponse = cryptoRepository.getCryptoData(id)
        }
    }
}