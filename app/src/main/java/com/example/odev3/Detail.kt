package com.example.odev3

import android.telecom.Call.Details
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.odev3.model.Country
import com.example.odev3.ui.theme.bg_primary
import com.example.odev3.ui.theme.bg_primaryDark
import com.example.odev3.ui.theme.new_amsterdam
import com.example.odev3.ui.theme.text_primary

@OptIn(ExperimentalGlideComposeApi::class, ExperimentalMaterial3Api::class)
@Composable
fun Detail(country_name: String?, country_code: String?,navController: NavController,darkTheme: Boolean = isSystemInDarkTheme()) {

    Scaffold(topBar = { CenterAlignedTopAppBar(
        title = { Text(text = "Detail", fontWeight = FontWeight.Bold, color = Color.White) },
        colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = if (darkTheme) bg_primaryDark else bg_primary),
    ) }) { paddingValues ->

        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            contentAlignment = Alignment.Center
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "Country: $country_name",
                    fontSize = 28.sp,
                    color = text_primary,
                    fontFamily = new_amsterdam
                )

                Spacer(modifier = Modifier.height(16.dp))

                GlideImage(
                    model = "https://flagsapi.com/$country_code/flat/64.png",
                    modifier = Modifier.size(128.dp),
                    contentDescription = "Country Flag"
                )
            }
        }
    }

}
