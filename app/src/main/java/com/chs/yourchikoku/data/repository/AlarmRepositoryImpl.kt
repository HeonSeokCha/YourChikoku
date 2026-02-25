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

    override suspend fun getAlarmInfo(alarmId: Int): AlarmInfo {
        return alarmInfoDao.getAlarm(alarmId).toAlarmInfo()
    }

    override suspend fun upsertAlarmInfo(vararg info: AlarmInfo) {
        alarmInfoDao.upsertEntity(
            *info.map { it.toAlarmInfoEntity() }.toTypedArray()
        )
    }

    override suspend fun deleteAlarmInfo(vararg info: AlarmInfo) {
        alarmInfoDao.deleteEntity(*info.map { it.toAlarmInfoEntity() }.toTypedArray())
    }

}