package com.chs.yourchikoku.data.db.entity

import androidx.room.Entity

@Entity(
    tableName = "alarm_infos"
)
data class AlarmInfoEntity(
    val createTime: Long,
    val title: String,
    val targetAlarmDate: Long? = null,
    val alarmTime: Long,
    val isAvoidHoliday: Boolean
)
