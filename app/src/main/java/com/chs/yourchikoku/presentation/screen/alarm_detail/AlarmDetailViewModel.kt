package com.chs.yourchikoku.presentation.screen.alarm_detail

import androidx.lifecycle.ViewModel
import com.chs.yourchikoku.domain.usecase.DeleteAlarmInfoUseCase
import com.chs.yourchikoku.domain.usecase.UpsertAlarmInfoUseCase
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class AlarmDetailViewModel(
    private val upsertAlarmInfoUseCase: UpsertAlarmInfoUseCase,
    private val deleteAlarmInfoUseCase: DeleteAlarmInfoUseCase
) : ViewModel() {

}