package com.coingeckoapitestapp.ui.item

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.coingeckoapitestapp.R
import com.coingeckoapitestapp.model.CryptoData
import com.coingeckoapitestapp.ui.theme.CoinGeckoApiTestAppTheme

@Composable
fun CryptoListItem(cryptoData: CryptoData) {
    Card(
        colors = CardDefaults.cardColors(containerColor = Color.White),
        modifier = Modifier
            .fillMaxWidth()
            .height(70.dp)
            .shadow(5.dp, shape = RoundedCornerShape(16.dp))
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.height(70.dp).fillMaxWidth()
        ) {
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "",
                modifier = Modifier
                    .size(40.dp)
            )
            Spacer(modifier = Modifier.padding(start = 20.dp))
            Column {
                Text(text = cryptoData.name)
                Text(text = cryptoData.symbol)
            }
        }
    }
}

@Preview
@Composable
fun TestCryptoListItem() {
    CoinGeckoApiTestAppTheme {
       // CryptoListItem()
    }
}