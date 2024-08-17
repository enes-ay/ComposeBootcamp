package com.example.odev3

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.sp

@Composable
fun Item(modifier: Modifier = Modifier, countries:Array<String>) {
    Row(modifier=Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.Start) {

            Text(text = "countries", fontSize = 23.sp)
            Image(
                painter = painterResource(id = R.drawable.ic_launcher_background),
                contentDescription = "d")

    }
}
