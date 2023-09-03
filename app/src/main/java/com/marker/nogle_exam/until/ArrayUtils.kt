package com.marker.nogle_exam.until

object ArrayUtils {
    fun mergeTwoListToPairList(
        array1: List<String>,
        array2: List<String>
    ): List<Pair<String, String>> {
        val resultList = mutableListOf<Pair<String, String>>()

        val maxSize = maxOf(array1.size, array2.size)

        for (i in 0 until maxSize) {
            val element1 = if (i < array1.size) array1[i] else ""
            val element2 = if (i < array2.size) array2[i] else ""
            resultList.add(Pair(element1, element2))
        }

        return resultList
    }
}