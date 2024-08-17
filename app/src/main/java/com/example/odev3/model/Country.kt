package com.example.odev3.model

data class Country(
    val name: String,
    val countryCode: String
) {
    val flagUrl: String
        get() = "https://flagsapi.com/$countryCode/shiny/64.png"
}