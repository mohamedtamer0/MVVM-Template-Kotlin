package com.example.mvvmtemplate.data.repository

import com.example.mvvmtemplate.data.local.model.DataModel
import com.example.mvvmtemplate.data.remote.dto.toDataModel
import com.example.mvvmtemplate.data.remote.webservice.WebService
import com.example.mvvmtemplate.domain.repository.DataRepo
import com.example.mvvmtemplate.util.ErrorType
import com.example.mvvmtemplate.util.Resource
import java.net.SocketTimeoutException
import javax.inject.Inject

class DataRepoImpl @Inject constructor(
    private val webService: WebService
) : DataRepo {
    override suspend fun getData(): Resource<DataModel> {
        try {
            val task = webService.getData()
            if (task.isSuccessful) {
                task.body()?.let {
                    return Resource.Success(data = it.toDataModel())
                } ?: return Resource.Error(errorType = ErrorType.EMPTY_DATA)
            } else {
                return Resource.Error()
            }
        } catch (e: SocketTimeoutException) {
            return Resource.Error(errorType = ErrorType.TIME_OUT)
        } catch (e: Exception) {
            return Resource.Error(message = e.localizedMessage)
        }
    }
}