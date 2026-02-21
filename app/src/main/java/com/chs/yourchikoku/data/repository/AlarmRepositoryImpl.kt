package com.chs.yourchikoku.data.repository

import com.chs.yourchikoku.data.db.dao.AlarmInfoDao
import com.chs.yourchikoku.domain.model.AlarmInfo
import com.chs.yourchikoku.domain.model.toAlarmInfo
import com.chs.yourchikoku.domain.model.toAlarmInfoEntity
import com.chs.yourchikoku.domain.repository.AlarmRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import org.koin.core.annotation.Single

@Single
class AlarmRepositoryImpl(
    private val alarmInfoDao: AlarmInfoDao
) : AlarmRepository {
    override fun getAllAlarmInfo(): Flow<List<AlarmInfo>> {
        return alarmInfoDao.getAllAlarm().map { it.map { it.toAlarmInfo() } }
    }

    override suspend fun upsertAlarmInfo(info: AlarmInfo) {
        alarmInfoDao.upsertEntity(info.toAlarmInfoEntity())
    }

    override suspend fun deleteAlarmInfo(vararg info: AlarmInfo) {
        alarmInfoDao.deleteEntity(*info.map { it.toAlarmInfoEntity() }.toTypedArray())
    }

}