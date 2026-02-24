package com.chs.yourchikoku.presentation.screen.home_screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.compose.viewModel
import com.chs.yourchikoku.domain.model.AlarmInfo
import com.chs.yourchikoku.domain.usecase.DeleteAlarmInfoUseCase
import com.chs.yourchikoku.domain.usecase.GetAlarmInfoUseCase
import com.chs.yourchikoku.domain.usecase.UpsertAlarmInfoUseCase
import com.chs.yourchikoku.presentation.screen.home_screen.HomeEffect.*
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import org.koin.android.annotation.KoinViewModel

@KoinViewModel
class HomeViewModel(
    private val getAlarmInfoUseCase: GetAlarmInfoUseCase,
    private val upsertAlarmInfoUseCase: UpsertAlarmInfoUseCase,
    private val deleteAlarmInfoUseCase: DeleteAlarmInfoUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(HomeState())
    val state: StateFlow<HomeState> = _state
        .onStart { initAlarmInfoList() }
        .stateIn(
            viewModelScope,
            SharingStarted.Lazily,
            _state.value
        )

    private val _effect: Channel<HomeEffect> = Channel(Channel.BUFFERED)
    val effect = _effect.receiveAsFlow()

    fun handleIntent(intent: HomeIntent) {
        when (intent) {
            is HomeIntent.ClickAlarmInfo -> {
                if (_state.value.isMultipleClick) {
                    _state.update { currentState ->
                        currentState.copy(
                            checkedAlarmList = currentState.alarmList.toMutableList()
                                .apply {
                                    this.add(intent.info)
                                }
                        )
                    }
                } else {
                    _effect.trySend(NavigateAlarmDetail(intent.info.alarmId))
                }
            }

            is HomeIntent.ClickAlarmToggle -> {
                updateAlarmToggleInfo(info = intent.alarmInfo, state = intent.toggleState)
            }

            is HomeIntent.LongClickAlarmInfo -> {
                _state.update {
                    it.copy(
                        isMultipleClick = !it.isMultipleClick,
                        checkedAlarmList = listOf(intent.info)
                    )
                }
            }

            HomeIntent.ClickDeleteAlarm -> deleteAlarmList()
            HomeIntent.ClickDisableAlarm -> updateDisableAlarmList()
        }
    }

    private fun initAlarmInfoList() {
        _state.update { it.copy(isLoadIng = true) }
        viewModelScope.launch {
            getAlarmInfoUseCase().collect { list ->
                _state.update {
                    it.copy(
                        alarmList = list,
                        isLoadIng = false
                    )
                }
            }
        }
    }

    private fun updateAlarmToggleInfo(
        info: AlarmInfo,
        state: Boolean
    ) {
        viewModelScope.launch {
            upsertAlarmInfoUseCase(
                info.copy(isEnabled = state)
            )
        }
    }

    private fun updateDisableAlarmList() {
        viewModelScope.launch {
            upsertAlarmInfoUseCase(
                *_state.value.checkedAlarmList.map {
                    it.copy(isEnabled = false)
                }.toTypedArray()
            )

            _state.update {
                it.copy(
                    checkedAlarmList = emptyList(),
                    isMultipleClick = false
                )
            }
        }
    }

    private fun deleteAlarmList() {
        viewModelScope.launch {
            deleteAlarmInfoUseCase(*_state.value.checkedAlarmList.toTypedArray())

            _state.update {
                it.copy(
                    checkedAlarmList = emptyList(),
                    isMultipleClick = false
                )
            }
        }
    }
}