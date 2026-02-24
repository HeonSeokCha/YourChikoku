package com.chs.yourchikoku.presentation.screen.home_screen

import com.chs.yourchikoku.domain.model.AlarmInfo

data class HomeState(
    val isLoadIng: Boolean = false,
    val alarmList: List<AlarmInfo> = emptyList(),
    val isMultipleClick: Boolean = false,
    val checkedAlarmList: List<AlarmInfo> = emptyList()
)
