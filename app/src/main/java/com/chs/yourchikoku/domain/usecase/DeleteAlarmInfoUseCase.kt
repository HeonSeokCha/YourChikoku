package com.chs.yourchikoku.domain.usecase

import com.chs.yourchikoku.domain.model.AlarmInfo
import com.chs.yourchikoku.domain.repository.AlarmRepository
import org.koin.core.annotation.Single

@Single
class DeleteAlarmInfoUseCase(
    private val repository: AlarmRepository
) {
    suspend operator fun invoke(vararg info: AlarmInfo) = repository.deleteAlarmInfo(*info)
}