package com.example.obbliapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.viewpager2.widget.ViewPager2
import com.example.obbliapp.databinding.FragmentFirstBinding
import com.example.obbliapp.ui.BaseFragment
import com.example.obbliapp.ui.adapter.CalendarPagerFragmentStateAdapter

class FirstFragment  : BaseFragment<FragmentFirstBinding>(FragmentFirstBinding::inflate) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
    }

    private fun initView() {
        val calendarPagerFragmentStateAdapter = CalendarPagerFragmentStateAdapter(requireActivity())
        binding.viewPagerCalendar.apply {
            adapter = calendarPagerFragmentStateAdapter
            orientation = ViewPager2.ORIENTATION_HORIZONTAL
        }
        calendarPagerFragmentStateAdapter.apply {
            binding.viewPagerCalendar.setCurrentItem(this.fragmentPosition, false)
        }
    }
}


