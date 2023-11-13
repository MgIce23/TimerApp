package com.aps.timerapp.screens

import android.graphics.Color
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.scaleIn
import androidx.compose.animation.scaleOut
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.PlayArrow
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.aps.timerapp.components.CircularKey
import com.aps.timerapp.components.TimeDisplay
import com.aps.timerapp.domain.KeyPad
import com.aps.timerapp.domain.model.TimeData

@Composable
fun TimerSelectionScreen(
    modifier: Modifier,
    timeState: TimeData,
    onKeyClick : (KeyPad) -> Unit
){
    val isPlayButtonVisible = timeState.isDataEmpty().not()

    Column(
        modifier = modifier,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TimeDisplay(
            time = timeState,
        )
        Spacer(modifier = Modifier.height(24.dp))

//        TimerKeypadScreen(
//            onKeyClick = { key ->
//                onKeyClick(key)
//            }
//        )
        Spacer(modifier = Modifier.height(16.dp))
        AnimatedVisibility(
            visible = isPlayButtonVisible,
            enter = scaleIn(),
            exit = scaleOut()
        ) {
            CircularKey(
                modifier = Modifier
                    .width(96.dp)
                    .height(96.dp),
                keypad = KeyPad.KeyPlay,
                backgroundColor = androidx.compose.ui.graphics.Color.Blue,
                icon = Icons.Outlined.PlayArrow,
                textColor = androidx.compose.ui.graphics.Color.Magenta,
                onClick = {
                    onKeyClick(it)
                }
            )
        }
    }
}