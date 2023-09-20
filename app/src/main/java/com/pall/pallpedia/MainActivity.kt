package com.pall.pallpedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar
import com.google.android.material.tabs.TabLayoutMediator
import com.pall.pallpedia.adapter.SectionPagerAdapter
import com.pall.pallpedia.data.NewsResponse
import com.pall.pallpedia.data.network.ApiClient
import com.pall.pallpedia.databinding.ActivityMainBinding
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding as ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setSupportActionBar(binding.toolBar)
        setContentView(binding.root)

        // set adapter ViewPager2 using SectionPagerAdapter class
        binding.vpContainer.adapter = SectionPagerAdapter(this)
        // array for set title tab item in TabLayout
        val listFragment = arrayOf("Common", "Daily", "Disaster", "Politic")

        // set TabLayout and ViewPager2 so, can bind each other
        TabLayoutMediator(binding.tabLayout, binding.vpContainer) { tab, position ->
            tab.text = listFragment[position]
        }.attach()

        ApiClient.retrofit.getCommonNews().enqueue(object : Callback<NewsResponse> {
            override fun onResponse(call: Call<NewsResponse>, response: Response<NewsResponse>) {
                Toast.makeText(this@MainActivity, "OK", Toast.LENGTH_SHORT).show()
                Log.i("MainActivity", "onResponse: ${response.body()}")
            }

            override fun onFailure(call: Call<NewsResponse>, t: Throwable) {
                Snackbar.make(
                    findViewById(com.google.android.material.R.id.content),
                   "Call Failed: " + t.localizedMessage,
                    Snackbar.LENGTH_SHORT
                ).show()
            }

        })
    }
}