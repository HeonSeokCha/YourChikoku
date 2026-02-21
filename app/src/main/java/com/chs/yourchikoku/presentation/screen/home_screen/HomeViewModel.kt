package com.chs.yourchikoku.presentation.screen.home_screen

import androidx.lifecycle.ViewModel
import com.chs.yourchikoku.domain.usecase.DeleteAlarmInfoUseCase
import com.chs.yourchikoku.domain.usecase.GetAlarmInfoUseCase
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getAlarmInfoUseCase: GetAlarmInfoUseCase,
    private val deleteAlarmInfoUseCase: DeleteAlarmInfoUseCase
): ViewModel() {

}