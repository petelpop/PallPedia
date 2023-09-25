package com.pall.pallpedia

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.google.android.material.snackbar.Snackbar
import com.pall.pallpedia.data.NewsResponse
import com.pall.pallpedia.data.network.ApiClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.http.Query

class NewsViewModel : ViewModel() {
    private val _commonNews = MutableLiveData<NewsResponse>()
    val commonNews get() = _commonNews as LiveData<NewsResponse>
    private val _aboutDaily = MutableLiveData<NewsResponse>()
    val aboutDaily get() = _aboutDaily as LiveData<NewsResponse>
    private val _aboutDisaster = MutableLiveData<NewsResponse>()
    val aboutDisaster get() = _aboutDisaster as LiveData<NewsResponse>
    private val _aboutPolitic = MutableLiveData<NewsResponse>()
    val aboutPolitic get() = _aboutPolitic as LiveData<NewsResponse>
    private val _searchNews = MutableLiveData<NewsResponse>()
    val searchNews get() = _searchNews as LiveData<NewsResponse>

    fun getCommonNews() {
        ApiClient.getApiService().getCommonNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _commonNews.postValue(response.body())
                } else Log.e(
                    "ViewModel",
                    "onFailedCall: Call error Http Status Code :" + response.code()
                )
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("ViewModel", "onFailure: " + t.localizedMessage )
            }

        })

    }

    fun searchNews(query: String) {
        ApiClient.getApiService().searchNews(query).enqueue(object: Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                if (response.isSuccessful) {
                    _searchNews.postValue(response.body())
                } else Log.e("NewsViewModel", "onResponse: ${response.message()}")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Log.e("NewsViewModel", "onFailure: ${t.localizedMessage}")
            }
        })
    }
}