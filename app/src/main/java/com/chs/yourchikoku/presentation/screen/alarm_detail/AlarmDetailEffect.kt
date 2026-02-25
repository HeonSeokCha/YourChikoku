package com.chs.yourchikoku.presentation.screen.alarm_detail

sealed interface AlarmDetailEffect {
    data object NavigateBack : AlarmDetailEffect
}