package com.pall.pallpedia.data.network

import android.util.Size
import com.pall.pallpedia.data.NewsResponse
import org.intellij.lang.annotations.Language
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface ApiService {
    @GET("/everything")
    fun getCommonNews(
        @Query("q") query: String = "daily",
        @Query("language") language: String = "en",
        @Query("sortBy") sortByte: String = "popularity",
        @Query("pageSize") pageSize: Int = 30,
        @Query("apiKey") apiKey: String = "89387cb598d6442088315b1a17cbebb5"
    ) : Call<NewsResponse>
}