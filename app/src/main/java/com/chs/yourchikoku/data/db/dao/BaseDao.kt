package com.chs.yourchikoku.data.db.dao

import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Upsert

interface BaseDao <T> {

    @Upsert
    suspend fun upsertEntity(entity: T)

    @Delete
    suspend fun deleteEntity(vararg entity: T)

}