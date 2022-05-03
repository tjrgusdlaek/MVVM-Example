package com.example.obbliapp.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.obbliapp.databinding.FragmentFirstBinding
import com.example.obbliapp.ui.adapter.HomeAdapter
import com.example.obbliapp.databinding.FragmentHomeBinding
import com.example.obbliapp.ui.BaseFragment
import com.example.obbliapp.ui.viewModel.ContentViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment  : BaseFragment<FragmentHomeBinding>(FragmentHomeBinding::inflate)  {

    private val viewModel: ContentViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val homeAdapter = HomeAdapter(viewModel)
        binding.homeRecyclerView.apply {
            layoutManager = LinearLayoutManager(requireContext(),LinearLayoutManager.VERTICAL,false)
            addItemDecoration(DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL))
            adapter = homeAdapter
            viewModel.contentList.observe(viewLifecycleOwner, Observer {
                homeAdapter.submitList(it)
            })
        }
    }

    override fun onResume() {
        super.onResume()
        viewModel.getContent()
    }
}