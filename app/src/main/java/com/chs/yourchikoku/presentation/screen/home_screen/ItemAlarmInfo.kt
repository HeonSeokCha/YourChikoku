package com.chs.yourchikoku.presentation.screen.home_screen

import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.chs.yourchikoku.domain.model.AlarmInfo
import java.time.LocalDate
import java.time.format.TextStyle
import java.time.temporal.WeekFields
import java.util.Locale

@Composable
fun ItemAlarmInfo(
    info: AlarmInfo,
    onClick: (AlarmInfo) -> Unit
) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .combinedClickable(
                onClick = {

                },
                onLongClick = {

                }
            )
    ) {
        Column {
            if (info.isAvoidHoliday) {
                Text(text = "공휴일에는 끄기")
            }

            Text(text = info.alarmTime.toString())

            if (info.alarmRepeatDateIdx.isNotEmpty()) {
                ItemWeeklyDateList(info.alarmRepeatDateIdx)
            }
        }

        Switch(
            checked = info.isEnabled,
            onCheckedChange = {

            }
        )
    }
}

@Composable
fun ItemWeeklyDateList(
    idxList: List<Int>
) {
    val weekFields = WeekFields.of(Locale.US)
    val firstDayOfWeek = weekFields.firstDayOfWeek

    val list = generateSequence(firstDayOfWeek) { it.plus(1) }
        .take(7)
        .toList()
        .map { day ->
            day.getDisplayName(TextStyle.SHORT, Locale.KOREAN)
        }
    Row(
        modifier = Modifier
            .fillMaxWidth()
    ) {
        repeat(list.count()) { idx ->
            if (idxList.contains(idx)) {
                Text(
                    text = list[idx],
                    color = Color.Cyan
                )
            } else {
                Text(text = list[idx])
            }
        }
    }
}