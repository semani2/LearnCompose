package com.saie.learncompose

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.saie.learncompose.ui.theme.LearnComposeTheme

class WellnessActivity: ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            LearnComposeTheme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    WellnessScreen()
                }
            }
        }
    }
}

@Composable
fun WellnessScreen(modifier: Modifier = Modifier) {
    WaterCounter(modifier)
}

@Composable
fun WaterCounter(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.padding(16.dp)) {
        var count by remember { mutableStateOf(0) }

        if (count > 0) {
            var showTask by remember { mutableStateOf(true) }

            if (showTask) {
                WellnessTaskItem(
                    taskName = "Have you taken your 15 minute walk today",
                    onClose = { showTask = false })
            }

            Text(
                text = "You've had $count glasses."
            )
        }

        Row(Modifier.padding(top = 8.dp)) {
            Button(
                onClick = { count++ },
                enabled = count < 10) {
                Text(text = "Add one")
            }

            Button(
                onClick = { count = 0 },
                Modifier.padding(start = 8.dp)) {
                Text(text = "Clear water count")
            }

        }
    }

}