package com.example.mvvmtemplate.data.local.model

import androidx.room.Entity

@Entity(tableName = "Database Model")
data class DataModel(
    val result: String
)