package dev.rakamin.newsapp.network

import dev.rakamin.newsapp.models.NewsResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsInterface {

    companion object {
        // News API Key
        const val API_KEY = "7250e4823c8047f28d9c82e66a911652"
        const val BASE_URL = "https://newsapi.org/"
        const val PAGE_SIZE = 20
    }

    @GET("v2/top-headlines")
    suspend fun getTopHeadlines(
        @Query("country") country: String = "us",
        @Query("pageSize") pageSize: Int = PAGE_SIZE,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse

    @GET("v2/everything")
    suspend fun getEverything(
        @Query("q") query: String = "technology",
        @Query("pageSize") pageSize: Int = PAGE_SIZE,
        @Query("page") page: Int = 1,
        @Query("apiKey") apiKey: String = API_KEY
    ): NewsResponse
}
