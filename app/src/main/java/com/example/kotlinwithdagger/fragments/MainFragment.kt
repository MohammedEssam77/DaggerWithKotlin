package com.example.kotlinwithdagger.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.kotlinwithdagger.adapter.DataAdapter
import com.example.kotlinwithdagger.databinding.FragmentMainBinding
import com.example.kotlinwithdagger.viewModel.NewsViewModel
import com.example.kotlinwithdagger.viewModel.NewsViewModel_Factory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint

class MainFragment : Fragment() {

    lateinit var binding: FragmentMainBinding
    private lateinit var viewModel: NewsViewModel
    private lateinit var dataAdapter: DataAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentMainBinding.inflate(inflater, container, false)
        viewModel = ViewModelProvider(this).get(NewsViewModel::class.java)
        dataAdapter= DataAdapter()
        binding.rvShowData.layoutManager = LinearLayoutManager(context)
        binding.rvShowData.adapter = dataAdapter
        getData()

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.apiLiveData.observe(viewLifecycleOwner, Observer {
            if (it != null) {
                dataAdapter.setList(it)
            } else {
                Toast.makeText(requireContext(), "Connection Failed", Toast.LENGTH_LONG).show()
            }
        })
    }

    private fun getData() {
        viewModel.getNews()
    }
}