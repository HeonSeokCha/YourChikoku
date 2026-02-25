package com.chs.yourchikoku.presentation.screen.alarm_detail

import java.time.LocalTime

sealed interface AlarmDetailIntent {
    data object ClickSaveButton : AlarmDetailIntent
    data object ClickBackButton : AlarmDetailIntent
    data class UpdateAlarmTime(val time: LocalTime) : AlarmDetailIntent
    data class UpdateAlarmTitle(val title: String) : AlarmDetailIntent
    data class UpdateTargetWalk(val walk: Int) : AlarmDetailIntent
    data class UpdateAlarmDateIdx(val idxList: List<Int>) : AlarmDetailIntent
}