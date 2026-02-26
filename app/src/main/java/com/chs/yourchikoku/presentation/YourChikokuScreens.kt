package com.chs.yourchikoku.presentation

import androidx.navigation3.runtime.NavKey
import com.chs.yourchikoku.domain.model.AlarmInfo
import kotlinx.serialization.Serializable

@Serializable
sealed interface YourChikokuScreens : NavKey {
    @Serializable
    data object HomeScreen : YourChikokuScreens

    @Serializable
    data class AlarmDetailScreen(val alarmId: Int) : YourChikokuScreens

    @Serializable
    data class StepAlarmScreen(val alarmId: Int) : YourChikokuScreens
}