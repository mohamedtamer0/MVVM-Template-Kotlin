package com.example.mvvmtemplate.domain.repository

import com.example.mvvmtemplate.data.local.model.DataModel
import com.example.mvvmtemplate.util.Resource


interface DataRepo {

    suspend fun getData(): Resource<DataModel>
}