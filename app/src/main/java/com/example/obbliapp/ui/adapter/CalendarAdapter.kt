package com.example.obbliapp.ui.main

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.obbliapp.databinding.ItemCalendarDateListBinding
import java.util.*

class CalendarAdapter(private val context: Context,private val calendarLayout: LinearLayout,private val date: Date) : RecyclerView.Adapter<CalendarAdapter.CalendarItemHolder>() {

    var dataList: ArrayList<Int> = arrayListOf()
    var dateCalendar= DateCalendar(date)

    init {
        dateCalendar.initBaseCalendar()
        dataList = dateCalendar.dateList
    }

    override fun onBindViewHolder(holder: CalendarItemHolder, position: Int) {

        val h = calendarLayout.height / 6
        holder.itemView.layoutParams.height = h

        holder.bind(dataList[position], position, context)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CalendarItemHolder {
        val binding = ItemCalendarDateListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return CalendarItemHolder(binding)
    }

    override fun getItemCount(): Int = dataList.size

    inner class CalendarItemHolder(private val binding : ItemCalendarDateListBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(data: Int, position: Int, context: Context) {
            val firstDateIndex = dateCalendar.prevTail
            val lastDateIndex = dataList.size - dateCalendar.nextHead - 1
            binding.itemCalendarDateText.text = data.toString()

//            val dateString: String = SimpleDateFormat("dd", Locale.KOREA).format(date)
//            val dateInt = dateString.toInt()
//            if (dataList[position] == dateInt) {
//                binding.itemCalendarDateText.setTypeface(binding.itemCalendarDateText.typeface, Typeface.BOLD)
//            }

            if (position < firstDateIndex || position > lastDateIndex) {
                binding.itemCalendarDateText.alpha = 0.4f
            }else{
                binding.itemCalendarDateText.alpha = 1f
            }
        }
    }
}