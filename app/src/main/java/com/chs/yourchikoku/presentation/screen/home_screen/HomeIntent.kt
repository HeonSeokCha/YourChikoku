package com.chs.yourchikoku.presentation.screen.home_screen

import com.chs.yourchikoku.domain.model.AlarmInfo

sealed interface HomeIntent {
    data class ClickAlarmInfo(val info: AlarmInfo) : HomeIntent
    data class ClickAlarmToggle(
        val alarmInfo: AlarmInfo,
        val toggleState: Boolean
    ) : HomeIntent
    data class LongClickAlarmInfo(val info: AlarmInfo) : HomeIntent
    data object ClickDisableAlarm : HomeIntent
    data object ClickDeleteAlarm : HomeIntent
}