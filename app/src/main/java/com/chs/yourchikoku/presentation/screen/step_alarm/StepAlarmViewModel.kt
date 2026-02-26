package com.chs.yourchikoku.presentation.screen.step_alarm

import androidx.lifecycle.ViewModel
import com.chs.yourchikoku.domain.usecase.UpsertAlarmInfoUseCase
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class StepAlarmViewModel(
    upsertAlarmInfoUseCase: UpsertAlarmInfoUseCase,
) : ViewModel() {

}