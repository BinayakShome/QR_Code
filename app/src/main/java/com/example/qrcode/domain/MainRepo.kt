package com.example.qrcode.domain

import kotlinx.coroutines.flow.Flow

interface MainRepo {

    fun startScanning(): Flow<String>
}