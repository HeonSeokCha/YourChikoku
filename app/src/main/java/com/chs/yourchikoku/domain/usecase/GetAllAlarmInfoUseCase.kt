package com.chs.yourchikoku.domain.usecase

import com.chs.yourchikoku.domain.model.AlarmInfo
import com.chs.yourchikoku.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow
import org.koin.core.annotation.Single

@Single
class GetAllAlarmInfoUseCase(
    private val repository: AlarmRepository
) {
    operator fun invoke(): Flow<List<AlarmInfo>> = repository.getAllAlarmInfo()
}