package com.example.odev3

import android.util.Log
import android.widget.ImageView
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarColors
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.rememberTextMeasurer
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.bumptech.glide.Glide
import com.bumptech.glide.integration.compose.ExperimentalGlideComposeApi
import com.bumptech.glide.integration.compose.GlideImage
import com.example.odev3.model.Country
import com.example.odev3.ui.theme.bg_primary
import com.example.odev3.ui.theme.bg_primaryDark
import com.example.odev3.ui.theme.new_amsterdam
import com.example.odev3.ui.theme.text_primary
import com.google.gson.Gson

@OptIn(ExperimentalMaterial3Api::class, ExperimentalGlideComposeApi::class)
@Composable
fun HomePage(darkTheme: Boolean = isSystemInDarkTheme(), navController: NavController) {

  Scaffold(topBar = { CenterAlignedTopAppBar(
      title = { Text(text = "Home", fontWeight = FontWeight.Bold, color = Color.White) },
      colors = TopAppBarDefaults.centerAlignedTopAppBarColors(containerColor = if (darkTheme) bg_primaryDark else bg_primary),
  ) }) { paddingValues ->
      val countries = listOf(
          Country("Belgium", "BE"),
          Country("Germany", "DE"),
          Country("France", "FR"),
          Country("Türkiye", "TR"),
          Country("Australia", "AU"),
          Country("Albania", "AL"),
          Country("Bangladesh", "BD"),
          Country("Belarus", "BY"),
          Country("Switzerland", "CH"),
          Country("Colombia", "CO"),
          Country("Finland", "FI"),

      )
      CountryList(countries = countries,paddingValues, navController = navController)

  }
}


@Composable
fun CountryList(countries: List<Country>, paddingValues: PaddingValues, navController: NavController) {

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues),
        contentPadding = PaddingValues(16.dp)
    ) {
        items(countries) { country ->
            CountryItem(country = country, navController)
        }
    }
}

@OptIn(ExperimentalGlideComposeApi::class)
@Composable
fun CountryItem(country: Country,navController: NavController) {

    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
            .clickable(onClick = {
                println("basıldı")
                navController.navigate("countryDetail/${country.countryCode}/${country.name}")
            }),
         verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = country.name,
            fontSize = 24.sp,
            style = MaterialTheme.typography.bodyMedium,
            modifier = Modifier.weight(1f),
            fontFamily = new_amsterdam
        )

        GlideImage(
            model = country.flagUrl,
            modifier = Modifier
                .size(64.dp)
                .padding(start = 8.dp),
            contentDescription = "${country.name} flag"
        )
    }

}


@Preview(showBackground = true)
@Composable
fun HomepagePreview(){
    HomePage(navController = rememberNavController())
}