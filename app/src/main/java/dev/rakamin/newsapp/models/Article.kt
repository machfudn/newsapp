package dev.rakamin.newsapp.models

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class Article(
    val title: String?,
    val urlToImage: String?,
    val publishedAt: String?,
    val url: String?,
    val source: Source?
) : Parcelable

@Parcelize
data class Source(
    val name: String?
) : Parcelable
