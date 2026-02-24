package com.chs.yourchikoku.domain.usecase

import com.chs.yourchikoku.domain.model.AlarmInfo
import com.chs.yourchikoku.domain.repository.AlarmRepository
import org.koin.core.annotation.Single

@Single
class UpsertAlarmInfoUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke(vararg info: AlarmInfo) = repository.upsertAlarmInfo(*info)
}