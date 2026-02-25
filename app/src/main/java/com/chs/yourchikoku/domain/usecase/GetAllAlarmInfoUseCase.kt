package com.chs.yourchikoku.domain.usecase

import com.chs.yourchikoku.domain.model.AlarmInfo
import com.chs.yourchikoku.domain.repository.AlarmRepository
import org.koin.core.annotation.Single

@Single
class GetAllAlarmInfoUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke(alarmId: Int): AlarmInfo = repository.getAlarmInfo(alarmId)
}