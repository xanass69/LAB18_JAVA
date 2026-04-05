package com.example.viewmodellivedatademoenrichi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.viewmodellivedatademoenrichi.ui.theme.ViewModelLiveDataDemoEnrichiTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ViewModelLiveDataDemoEnrichiTheme {
                CounterScreen()
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        println("Activity détruite (mais ViewModel survit)")
    }
}

@Composable
fun CounterScreen() {
    // ViewModel survit à la rotation !
    val viewModel: CounterViewModel = viewModel()
    val count by viewModel.count.collectAsState()

    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = count.toString(),
            fontSize = 80.sp,
            modifier = Modifier.padding(bottom = 32.dp)
        )

        Button(
            onClick = { viewModel.increment() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("INCRÉMENTER")
        }

        Button(
            onClick = { viewModel.decrement() },
            modifier = Modifier.padding(bottom = 16.dp)
        ) {
            Text("DÉCRÉMENTER")
        }

        Button(
            onClick = { viewModel.reset() }
        ) {
            Text("RÉINITIALISER")
        }
    }
}