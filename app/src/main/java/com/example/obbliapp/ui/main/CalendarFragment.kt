package com.example.obbliapp.ui.main

import android.os.Bundle
import android.util.Log
import androidx.navigation.fragment.findNavController
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.PagerSnapHelper
import androidx.viewpager2.widget.ViewPager2
import com.example.obbliapp.R
import com.example.obbliapp.databinding.FragmentCalendarBinding
import com.example.obbliapp.ui.adapter.CalendarMonthAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CalendarFragment : Fragment() {
    private lateinit var binding : FragmentCalendarBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentCalendarBinding.inflate(inflater,container,false)

        val monthListManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val monthListAdapter = CalendarMonthAdapter()

//        binding.viewPager.apply {
//            adapter = monthListAdapter
//            orientation = ViewPager2.ORIENTATION_HORIZONTAL
////            registerOnPageChangeCallback(object :ViewPager2.OnPageChangeCallback(){
////                override fun onPageSelected(position: Int) {
////                    super.onPageSelected(position)
////                    Log.d("ViewPagerFragment", "Page ${position+1}")
////                }
////            })
//        }

        binding.button.setOnClickListener {
            findNavController().navigate(R.id.action_chatFragment_to_editCalendar)
        }

        binding.calendarCustom.apply {
            layoutManager = monthListManager
            adapter = monthListAdapter
            scrollToPosition(Int.MAX_VALUE/2)
        }
        val snap = PagerSnapHelper()
        snap.attachToRecyclerView(binding.calendarCustom)
        return binding.root
    }


}