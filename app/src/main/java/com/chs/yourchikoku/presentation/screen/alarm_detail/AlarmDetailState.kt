package com.chs.yourchikoku.presentation.screen.alarm_detail

data class AlarmDetailState(
    val alarmTimeHourIdx: Int,
    val alarmMinutesIdx: Int,
    val alamRepeatDateIdxList: List<Int>,
    val alarmTitle: String
)