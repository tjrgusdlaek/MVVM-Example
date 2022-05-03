package com.example.obbliapp.ui.main

import android.os.Bundle
import android.view.View
import androidx.recyclerview.widget.GridLayoutManager
import com.example.obbliapp.R
import com.example.obbliapp.databinding.FragmentCalendarBinding
import com.example.obbliapp.ui.BaseFragment
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class CalendarFragment (index: Int): BaseFragment<FragmentCalendarBinding>(FragmentCalendarBinding::inflate){

    private var pageIndex = index
    private lateinit var currentDate: Date


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView(view)
        initCalendar()
    }


    private fun initView(view: View) {
        pageIndex -= (Int.MAX_VALUE / 2)
        val date = Calendar.getInstance().run {
            add(Calendar.MONTH, pageIndex)
            time
        }
        currentDate = date
        val datetime: String = SimpleDateFormat(requireContext().getString(R.string.calendar_year_month_format), Locale.KOREA).format(date.time)
        binding.calendarYearMonthText.text = datetime
    }

    private fun initCalendar() {
        val calendarAdapter = CalendarAdapter(requireContext(), binding.calendarLayout, currentDate)
        binding.calendarView.apply {
            adapter = calendarAdapter
            layoutManager = GridLayoutManager(requireContext(), 7, GridLayoutManager.VERTICAL, false)
            setHasFixedSize(true)
        }
    }

}