package com.example.qrcode.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun MainScreen(viewModel: MainViewModel = hiltViewModel())
{
    val state = viewModel.state.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(vertical = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(modifier = Modifier
            .fillMaxSize()
            .weight(0.5f), contentAlignment = Alignment.Center) {
            Text(text =  state.value.details,
                modifier = Modifier
                    .padding(start = 20.dp, end =20.dp),
                fontSize = 20.sp)
        }

        Box(modifier = Modifier
            .fillMaxSize()
            .padding(bottom = 140.dp)
            .weight(0.5f), contentAlignment = Alignment.BottomCenter) {
            Button(onClick = { viewModel.startScanning() }) {
                Text(text = "Start Scanning",
                    fontSize = 20.sp)
            }
        }


    }

}