package com.marker.nogle_exam.service.domain

import kotlinx.coroutines.flow.StateFlow

interface IBtseWssService {

    fun getBtseWssStateFlow(): StateFlow<BtseWss>

    fun requestFeaturesSocket()

    fun sendMessage(message: String)

    fun closeSocket()
}

sealed class BtseWss {
    object Empty : BtseWss()
    object Connected : BtseWss()
    data class Message(val data: String) : BtseWss()
    object Closed : BtseWss()
}