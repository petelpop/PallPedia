package com.pall.pallpedia

import android.app.SearchManager
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.LinearLayout
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pall.pallpedia.adapter.NewsAdapter
import com.pall.pallpedia.databinding.ActivityDetailBinding
import com.pall.pallpedia.databinding.ActivitySearchableBinding

class SearchableActivity : AppCompatActivity() {
    private var _binding: ActivitySearchableBinding? = null
    private val binding get() = _binding as ActivitySearchableBinding

    private var _searchViewModel: NewsViewModel? = null
    private val searchViewModel get() = _searchViewModel as NewsViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivitySearchableBinding.inflate(layoutInflater)
        setContentView(binding.root)

        _searchViewModel = ViewModelProvider(this)[NewsViewModel::class.java]


        // Verify the action and get the query
        if (Intent.ACTION_SEARCH == intent.action) {
            //kotlin scope - also
            // mengambil value dari code yang mengimplementasikannya
            // kemudian memberikannya kedalam body lambda expression
            intent.getStringExtra(SearchManager.QUERY)?.also { query ->
                doMySearch(query)
            }
        }

        searchViewModel.searchNews.observe(this) {
            binding.rvSearchResult.apply {
                val mAdapter = NewsAdapter()
                mAdapter.setData(it.articles)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(this@SearchableActivity)
            }
        }
    }

    private fun doMySearch(query: String) {
        Toast.makeText(this, "query", Toast.LENGTH_SHORT).show()
    }


}