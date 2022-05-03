package com.example.obbliapp.ui.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.obbliapp.ui.main.CalendarFragment

class CalendarPagerFragmentStateAdapter(fragmentActivity: FragmentActivity): FragmentStateAdapter(fragmentActivity) {
    private val pageCount = Int.MAX_VALUE
    val fragmentPosition = Int.MAX_VALUE / 2

    override fun getItemCount(): Int = pageCount
    override fun createFragment(position: Int): Fragment {
        return CalendarFragment(position)
    }
}