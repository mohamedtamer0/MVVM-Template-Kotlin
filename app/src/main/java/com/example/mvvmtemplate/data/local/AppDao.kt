package com.example.mvvmtemplate.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy.REPLACE
import com.example.mvvmtemplate.data.local.model.DataModel

@Dao
interface AppDao {
    @Insert(onConflict = REPLACE)
    suspend fun insertData(dataModel: DataModel)
}
