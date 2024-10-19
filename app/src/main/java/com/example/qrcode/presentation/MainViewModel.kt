package com.example.qrcode.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.qrcode.domain.MainRepo
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: MainRepo
)
    : ViewModel() {

        private val _state = MutableStateFlow(MainScreenState())
        val state = _state.asStateFlow()

    fun startScanning(){
        viewModelScope.launch {
            repo.startScanning().collect{
                if (!it.isNullOrBlank()){
                    _state.value = state.value.copy(
                        details = it
                    )
                }
            }
        }
    }
}