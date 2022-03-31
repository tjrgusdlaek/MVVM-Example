package com.example.obbliapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.obbliapp.adapter.HomeAdapter
import com.example.obbliapp.data.entities.ContentEntity
import com.example.obbliapp.databinding.FragmentHomeBinding
import com.example.obbliapp.data.repository.HomeRepository
import com.example.obbliapp.viewModel.HomeViewModel
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding
    private val viewModel: HomeViewModel by activityViewModels()
    private lateinit var adapter: HomeAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(inflater,container,false)

        binding.fragment =this
        binding.viewModel = viewModel
        initView()
        return binding.root
    }


    private fun initView() {
        binding.homeRecyclerView.layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)

        binding.homeRecyclerView.addItemDecoration(
            DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
        adapter = HomeAdapter()
        binding.homeRecyclerView.adapter = adapter
        viewModel.contentList.observe(viewLifecycleOwner, Observer {
            adapter.submitList(it)
        })
    }

}