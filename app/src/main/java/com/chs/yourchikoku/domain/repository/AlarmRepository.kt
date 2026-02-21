package com.chs.yourchikoku.domain.repository

import com.chs.yourchikoku.domain.model.AlarmInfo
import kotlinx.coroutines.flow.Flow

interface AlarmRepository {
    fun getAllAlarmInfo(): Flow<List<AlarmInfo>>
    suspend fun upsertAlarmInfo(info: AlarmInfo)
    suspend fun deleteAlarmInfo(vararg info: AlarmInfo)
}