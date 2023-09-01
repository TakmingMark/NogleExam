package com.marker.nogle_exam.data.model

data class Market(
    val code: Int,
    val `data`: List<Data>,
    val msg: String,
    val success: Boolean,
    val time: Long
)