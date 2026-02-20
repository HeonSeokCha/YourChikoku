package com.chs.yourchikoku.data.db.dao

import androidx.room.Delete
import androidx.room.Insert

interface BaseDao <T> {

    @Insert
    suspend fun insertEntity(entity: T)

    @Delete
    suspend fun deleteEntity(vararg entity: T)

}