package com.example.mvvmtemplate.presentation.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mvvmtemplate.domain.repository.DataRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val dataRepo: DataRepo
) : ViewModel() {
    fun getData() {
        viewModelScope.launch(Dispatchers.IO) {
            dataRepo.getData()
        }
    }
}