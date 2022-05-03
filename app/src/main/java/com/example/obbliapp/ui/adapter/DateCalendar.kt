package com.example.obbliapp.ui.main

import java.util.Calendar
import java.util.*

class DateCalendar(date: Date) {

    private val DAYS_OF_WEEK = 6
    private val LOW_OF_CALENDAR = 5
    private val calendar = Calendar.getInstance()

    var prevTail = 0
    var nextHead = 0
    var currentMaxDate = 0
    var dateList = arrayListOf<Int>()

    init {
        calendar.time = date
    }

    fun initBaseCalendar() {
        makeMonthDate()
    }

    private fun makeMonthDate() {
        dateList.clear()
        calendar.set(Calendar.DATE, 1)
        currentMaxDate = calendar.getActualMaximum(Calendar.DAY_OF_MONTH)
        prevTail = calendar.get(Calendar.DAY_OF_WEEK) - 1
        makePrevTail(calendar.clone() as Calendar)
        makeCurrentMonth(calendar)
        nextHead = LOW_OF_CALENDAR * DAYS_OF_WEEK - (prevTail + currentMaxDate)
        makeNextHead()
    }

    private fun makePrevTail(calendar: Calendar) {
        calendar.set(Calendar.MONTH, calendar.get(Calendar.MONTH) - 1)
        val maxDate = calendar.getActualMaximum(Calendar.DATE)
        var maxOffsetDate = maxDate - prevTail
        for (i in 1..prevTail) dateList.add(++maxOffsetDate)
    }

    private fun makeCurrentMonth(calendar: Calendar) {
        for (i in 1..calendar.getActualMaximum(Calendar.DATE)) dateList.add(i)
    }

    private fun makeNextHead() {
        var date = 1
        for (i in 1..nextHead) dateList.add(date++)
    }
}