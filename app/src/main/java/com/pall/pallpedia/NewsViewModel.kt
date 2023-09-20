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

class NewsViewModel : ViewModel() {
    private val _commonNews = MutableLiveData<NewsResponse>()
    val commonNews get() = _commonNews as LiveData<NewsResponse>

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
}