package com.example.mvvmtemplate.data.remote.dto

import com.example.mvvmtemplate.data.local.model.DataModel
import com.google.gson.annotations.SerializedName

data class GetDataDto(
    @SerializedName("result")
    val result: String
)

fun GetDataDto.toDataModel(): DataModel {
    return DataModel(result = this.result)
}