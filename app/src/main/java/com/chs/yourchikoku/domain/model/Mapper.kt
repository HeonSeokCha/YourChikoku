package com.chs.yourchikoku.domain.model

import com.chs.yourchikoku.common.toLocalDate
import com.chs.yourchikoku.common.toMillis
import com.chs.yourchikoku.data.db.entity.AlarmInfoEntity
import java.time.LocalTime

fun AlarmInfo.toAlarmInfoEntity(): AlarmInfoEntity {
    return AlarmInfoEntity(
        title = this.title,
        alarmTime = this.alarmTime.toNanoOfDay(),
        targetAlarmDate = this.alarmTargetDate?.toMillis(),
        isAvoidHoliday = this.isAvoidHoliday,
        repeatAlarmDateList = this.alarmRepeatDateIdx.toString(),
        isEnabled = this.isEnabled
    )
}

fun AlarmInfoEntity.toAlarmInfo(): AlarmInfo {
    return AlarmInfo(
        title = this.title,
        alarmRepeatDateIdx = this.repeatAlarmDateList.split(",").map { it.toInt() },
        alarmTargetDate = this.targetAlarmDate?.toLocalDate(),
        alarmTime = LocalTime.ofNanoOfDay(this.alarmTime),
        isAvoidHoliday = this.isAvoidHoliday,
        isEnabled = this.isEnabled
    )
}