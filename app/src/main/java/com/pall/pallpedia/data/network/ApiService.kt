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
    ) : Call<NewsResponse>

    @GET("everything")
    fun getDisasterNews(
        @Query("q") keyWord: String = "disaster",
        @Query("language") language: String = "en"
    ) : Call<NewsResponse>

    @GET("top-headLines")
    fun getPoliticNews(
        @Query("sources") sources:String = "politic"
    ) : Call<NewsResponse>

    @GET("everything")
    fun getDailyNews(
        @Query("q") keyWord: String = "daily"
    ) : Call<NewsResponse>
}