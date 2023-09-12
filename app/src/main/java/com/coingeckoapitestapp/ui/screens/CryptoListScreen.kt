package com.coingeckoapitestapp.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coingeckoapitestapp.ui.item.CryptoListItem
import com.coingeckoapitestapp.ui.theme.CoinGeckoApiTestAppTheme
import org.koin.androidx.compose.koinViewModel

@Composable
fun CryptoListScreen() {
    val viewModel: CryptoListScreenViewModel = koinViewModel()
    val listCrypto = viewModel.listCryptoCoin.collectAsState()

    LazyColumn(
        verticalArrangement = Arrangement.spacedBy(20.dp),
        modifier = Modifier
            .padding(horizontal = 10.dp)
    ) {
        item {
            Spacer(modifier = Modifier.padding(top = 5.dp))
        }
        items(listCrypto.value) { cryptoData ->
            CryptoListItem(cryptoData)
        }
        item {
            Spacer(modifier = Modifier.padding(top = 5.dp))
        }
    }
}

@Preview
@Composable
fun TestCryptoListScreen() {
    CoinGeckoApiTestAppTheme {
        CryptoListScreen()
    }
}
