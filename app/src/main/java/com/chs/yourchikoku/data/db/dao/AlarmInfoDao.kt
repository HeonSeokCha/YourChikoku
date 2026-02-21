package com.chs.yourchikoku.data.db.dao

import androidx.room.Dao
import androidx.room.Query
import com.chs.yourchikoku.data.db.entity.AlarmInfoEntity
import kotlinx.coroutines.flow.Flow

@Dao
abstract class AlarmInfoDao : BaseDao<AlarmInfoEntity> {
    @Query("SELECT * FROM alarm_infos order by createTime")
    abstract fun getAllAlarm(): Flow<List<AlarmInfoEntity>>
}