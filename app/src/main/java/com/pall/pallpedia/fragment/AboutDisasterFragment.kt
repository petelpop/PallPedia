package com.pall.pallpedia.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.pall.pallpedia.NewsViewModel
import com.pall.pallpedia.R
import com.pall.pallpedia.adapter.NewsAdapter
import com.pall.pallpedia.databinding.FragmentAboutDisasterBinding
import com.pall.pallpedia.databinding.FragmentCommonBinding

class AboutDisasterFragment : Fragment() {

    private var _binding : FragmentAboutDisasterBinding? = null
    private val binding get() = _binding as FragmentAboutDisasterBinding
    private var _viewModel : NewsViewModel? = null
    private val viewModel get() = _viewModel as NewsViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentAboutDisasterBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.loadingView.root.visibility = View.VISIBLE
        _viewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        viewModel.getDisasterNews()
        viewModel.commonNews.observe(viewLifecycleOwner) {
            val data = it.articles
            Log.i("AboutDisasterFragment", "onResponse: $it ")
            binding.rvAboutDisaster.apply {
                val mAdapter = NewsAdapter()
                mAdapter.setData(data)
                adapter = mAdapter
                layoutManager = LinearLayoutManager(context)
            }
            binding.loadingView.root.visibility = View.GONE
        }
    }
}