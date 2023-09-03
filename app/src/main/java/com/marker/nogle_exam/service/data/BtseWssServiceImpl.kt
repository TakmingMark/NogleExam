package com.marker.nogle_exam.service.data

import com.marker.nogle_exam.service.domain.BtseWss
import com.marker.nogle_exam.service.domain.IBtseWssService
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.runBlocking
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener

class BtseWssServiceImpl(private val okHttpClient: OkHttpClient) : IBtseWssService {
    private var webSocket: WebSocket? = null
    private val _btseWssStateFlow = MutableStateFlow<BtseWss>(BtseWss.Empty)


    private val webSocketListener = object : WebSocketListener() {
        override fun onOpen(webSocket: WebSocket, response: Response) {
            super.onOpen(webSocket, response)
            runBlocking {
                _btseWssStateFlow.emit(BtseWss.Connected)
            }
        }

        override fun onMessage(webSocket: WebSocket, text: String) {
            super.onMessage(webSocket, text)
            runBlocking {
                _btseWssStateFlow.emit(BtseWss.Message(text))
            }
        }

        override fun onClosed(webSocket: WebSocket, code: Int, reason: String) {
            super.onClosed(webSocket, code, reason)
            runBlocking {
                _btseWssStateFlow.emit(BtseWss.Closed)
            }
        }

        override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
            super.onFailure(webSocket, t, response)
            runBlocking {
                _btseWssStateFlow.emit(BtseWss.Closed)
            }
        }
    }

    override fun getBtseWssStateFlow(): StateFlow<BtseWss> {
        return _btseWssStateFlow.asStateFlow()
    }

    override fun requestFeaturesSocket() {
        val request = Request.Builder()
            .url("wss://testws.btse.io/ws/futures")
            .build()
        webSocket = okHttpClient.newWebSocket(request, webSocketListener)
    }

    override fun sendMessage(message: String) {
        webSocket?.send(message)
    }

    override fun closeSocket() {
        webSocket?.cancel()
    }
}