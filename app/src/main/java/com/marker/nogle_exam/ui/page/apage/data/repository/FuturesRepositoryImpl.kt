package com.marker.nogle_exam.ui.page.apage.data.repository

import com.google.gson.Gson
import com.google.gson.JsonObject
import com.marker.nogle_exam.data.model.features.CoinData
import com.marker.nogle_exam.service.domain.BtseWss
import com.marker.nogle_exam.service.domain.IBtseWssService
import com.marker.nogle_exam.ui.page.apage.domain.repository.FuturesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.channelFlow
import kotlinx.coroutines.flow.collectLatest
import java.text.DecimalFormat

class FuturesRepositoryImpl(private val btseWssService: IBtseWssService) : FuturesRepository {
    private val gson = Gson()
    private val decimalFormat = DecimalFormat("#.######")

    override suspend fun getFilterPrices(filterType: Int): Flow<List<Double>> {
        btseWssService.requestFeaturesSocket()

        return channelFlow {
            btseWssService.getBtseWssStateFlow().collectLatest {
                when (it) {
                    is BtseWss.Connected -> {
                        btseWssService.sendMessage("{\"op\": \"subscribe\", \"args\": [\"coinIndex\"]} ")
                    }

                    is BtseWss.Message -> {
                        val jsonObject = gson.fromJson(it.data, JsonObject::class.java)
                        val dataObject = jsonObject.getAsJsonObject("data") ?: return@collectLatest

                        val prices = dataObject.entrySet().map { entry ->
                            gson.fromJson(entry.value, CoinData::class.java)
                        }.filter { coninData ->
                            coninData.type == filterType
                        }.map { coninData ->
                            decimalFormat.format(coninData.price).toDouble()
                        }
                        send(prices)
                    }

                    else -> {}
                }
            }
        }
    }
}