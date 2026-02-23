package com.chs.yourchikoku.data.db.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(
    tableName = "alarm_infos"
)
data class AlarmInfoEntity(
    @PrimaryKey(autoGenerate = true)
    val alarmId: Int = 0,
    val title: String,
    val targetAlarmDate: Long? = null,
    val repeatAlarmDateList: String,
    val alarmTime: Long,
    val isAvoidHoliday: Boolean,
    val isEnabled: Boolean,
    val createTime: Long = System.currentTimeMillis()
)
