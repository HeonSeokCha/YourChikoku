package com.chs.yourchikoku.presentation.screen.home_screen

import com.chs.yourchikoku.domain.model.AlarmInfo

sealed interface HomeEffect {
    data class NavigateAlarmDetail(val id: Int) : HomeEffect
}