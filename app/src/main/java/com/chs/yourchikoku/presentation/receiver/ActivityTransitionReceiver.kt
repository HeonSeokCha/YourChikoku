package com.chs.yourchikoku.presentation.receiver

import android.app.AlarmManager
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import com.google.android.gms.location.ActivityTransitionResult
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlin.getValue

class ActivityTransitionReceiver : BroadcastReceiver(), KoinComponent {
    private val alarmManager: AlarmManager by inject()

    override fun onReceive(context: Context, intent: Intent) {
        if (ActivityTransitionResult.hasResult(intent)) {
            val result = ActivityTransitionResult.extractResult(intent)

            if (result == null || result.transitionEvents.isEmpty()) return
        }
    }
}