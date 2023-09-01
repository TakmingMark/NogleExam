package com.marker.nogle_exam.data.model

data class CoinFuncSwitch(
    val listedAsSpotQuote: Boolean,
    val walletConvert: Boolean,
    val walletConvertFrom: Boolean,
    val walletDeposit: Boolean,
    val walletOtc: Boolean,
    val walletTransferToFutures: Boolean,
    val walletTransferToUser: Boolean,
    val walletWithdraw: Boolean
)