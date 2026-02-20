package com.chs.yourchikoku.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.chs.yourchikoku.data.db.dao.AlarmInfoDao
import com.chs.yourchikoku.data.db.entity.AlarmInfoEntity

@Database(
    entities = [
        AlarmInfoEntity::class
    ],
    version = 1,
    exportSchema = false
)
abstract class YourChikokuDatabase : RoomDatabase() {
    abstract val alarmInfoDao: AlarmInfoDao

    companion object {
        fun getInstance(context: Context): YourChikokuDatabase {
            return Room
                .databaseBuilder(
                    context = context,
                    klass = YourChikokuDatabase::class.java,
                    "your_chikoku_db"
                )
                .build()
        }
    }
}