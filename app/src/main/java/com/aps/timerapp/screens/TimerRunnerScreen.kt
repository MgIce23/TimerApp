package com.aps.timerapp.screens

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PauseCircle
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.aps.timerapp.components.CircularKey
import com.aps.timerapp.domain.KeyPad
import kotlinx.coroutines.delay

@Composable
fun TimerRunnerScreen(
    modifier: Modifier,
    onTimerStop: (KeyPad) -> Unit
) {
    var stopButtonVisible by remember {
        mutableStateOf(false)
    }

    LaunchedEffect(key1 = true) {
        delay(300)
        stopButtonVisible = true
    }

    Column(
        modifier = modifier.padding(top = 24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Box(
            modifier = Modifier
                .width(300.dp)
                .height(300.dp)
                .background(Color.Yellow)
        )

        Spacer(modifier = Modifier.height(16.dp))

        AnimatedVisibility(
            visible = stopButtonVisible,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            CircularKey(modifier = Modifier.width(96.dp)
                .height(96.dp),
                keypad = KeyPad.KeyStop, backgroundColor = Color.Blue,
                icon = Icons.Outlined.PauseCircle,
                textColor = Color.White, onClick = {
                    onTimerStop(it)
                } )
        }
    }
}