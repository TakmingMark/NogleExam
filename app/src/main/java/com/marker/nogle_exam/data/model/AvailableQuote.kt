package com.marker.nogle_exam.data.model

data class AvailableQuote(
    val coinFuncSwitch: CoinFuncSwitch,
    val crypto: Boolean,
    val decimals: Int,
    val depositMin: Double,
    val fiat: Boolean,
    val gmtCreate: Long,
    val gmtModified: Long,
    val id: Int,
    val increment: Double,
    val isDefault: Int,
    val isQuote: Boolean,
    val isSettlement: Int,
    val isStable: Boolean,
    val isSupportAddressExtension: Boolean,
    val logo: String,
    val maxSize: Double,
    val minSize: Double,
    val multiplier: Int,
    val name: String,
    val scale: Int,
    val shortName: String,
    val sortId: Int,
    val status: Int,
    val symbol: String,
    val type: Int,
    val typeEnum: String
)