package com.chs.yourchikoku.domain.model

import java.time.LocalDate
import java.time.LocalTime

data class AlarmInfo(
    val alarmId: Int,
    val title: String,
    val alarmRepeatDateIdx: List<Int> = emptyList(),
    val alarmTargetDate: LocalDate? = null,
    val alarmTime: LocalTime,
    val isAvoidHoliday: Boolean,
    val isEnabled: Boolean
)