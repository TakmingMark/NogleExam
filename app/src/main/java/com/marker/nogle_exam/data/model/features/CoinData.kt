package com.marker.nogle_exam.data.model.features

data class CoinData(
    val id: String,
    val name: String,
    val type: Int,
    val price: Double,
    val gains: Int,
    val open: Int,
    val high: Int,
    val low: Int,
    val volume: Int,
    val amount: Int
)