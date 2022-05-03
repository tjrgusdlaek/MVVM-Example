package com.example.obbliapp.ui.adapter

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.RelativeLayout
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.obbliapp.R
import java.util.*

class CalendarDayAdapter (private val tempMonth:Int,private val dayList: MutableList<Date>): RecyclerView.Adapter<CalendarDayAdapter.DayView>() {
    private val ROW = 5

    inner class DayView(view: View): RecyclerView.ViewHolder(view){
        val item_day_text=view.findViewById<TextView>(R.id.item_day_text)
        val item_day_layout=view.findViewById<RelativeLayout>(R.id.item_day_layout)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DayView {
        var view = LayoutInflater.from(parent.context).inflate(R.layout.item_calendar_day_recyclerview, parent, false)
        return DayView(view)
    }

    override fun onBindViewHolder(holder: DayView, position: Int) {
        holder.item_day_layout.setOnClickListener {
            Toast.makeText(holder.itemView.context, "${dayList[position]}", Toast.LENGTH_SHORT).show()
        }

        holder.item_day_text.text = dayList[position].date.toString()
        holder.item_day_text.setTextColor(when(position % 7) {
            0 -> Color.RED
            6 -> Color.BLUE
            else -> Color.BLACK
        })

        if(tempMonth != dayList[position].month - 1) {
            holder.item_day_text.alpha = 0.4f
        }
    }

    override fun getItemCount(): Int {
        return ROW * 7
    }
}