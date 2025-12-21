package dev.rakamin.newsapp.utils

import java.text.SimpleDateFormat
import java.util.*

object DateFormatter {

    fun format(date: String?): String {
        if (date == null) return ""
        return try {
            val input = SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss'Z'", Locale.getDefault())
            val output = SimpleDateFormat("dd MMM yyyy", Locale.getDefault())
            output.format(input.parse(date)!!)
        } catch (e: Exception) {
            ""
        }
    }
}
