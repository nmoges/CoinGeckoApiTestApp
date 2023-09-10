package com.coingeckoapitestapp.viewModel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.coingeckoapitestapp.Crypto
import com.coingeckoapitestapp.model.CryptoInfoResponse
import com.coingeckoapitestapp.repository.CryptoRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class CryptoViewModel(
    private val cryptoRepository: CryptoRepository
): ViewModel() {

    private val _listCryptoCoin = MutableStateFlow<List<CryptoInfoResponse>>(mutableListOf())
    val listCryptoCoin: StateFlow<List<CryptoInfoResponse>>
        get() = _listCryptoCoin

    fun getCryptoList() {
        viewModelScope.launch {
            val list: MutableList<CryptoInfoResponse> = mutableListOf()
            cryptoRepository.getCryptoList().forEach {
                if (Crypto.isInFilterList(it.name)) {
                    list.add(it)
                }
            }
            _listCryptoCoin.value = list
        }
    }
}