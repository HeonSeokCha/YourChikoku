package com.chs.yourchikoku.di

import android.app.AlarmManager
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.PreferenceDataStoreFactory
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.preferencesDataStoreFile
import com.chs.yourchikoku.common.Constants
import com.chs.yourchikoku.data.db.YourChikokuDatabase
import com.chs.yourchikoku.data.db.dao.AlarmInfoDao
import com.chs.yourchikoku.data.source.DataPrefSource
import org.koin.core.annotation.Factory
import org.koin.core.annotation.Module
import org.koin.core.annotation.Single

@Module
class AppModule {

    @Single
    fun provideAlarmManger(context: Context): AlarmManager {
        return context.getSystemService(Context.ALARM_SERVICE) as AlarmManager
    }


    @Single
    fun provideDataStorePref(context: Context): DataStore<Preferences> {
        return PreferenceDataStoreFactory.create {
            context.preferencesDataStoreFile(Constants.PREF_NAME)
        }
    }

    @Single
    fun provideDatabase(context: Context): YourChikokuDatabase {
        return YourChikokuDatabase.getInstance(context)
    }

    @Factory
    fun provideAlarmInfoDao(db: YourChikokuDatabase): AlarmInfoDao {
        return db.alarmInfoDao
    }

    @Factory
    fun provideDataStoreSource(dataStorePref: DataStore<Preferences>): DataPrefSource {
        return DataPrefSource(dataStorePref)
    }
}
