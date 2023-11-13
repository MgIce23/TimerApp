package com.aps.timerapp.screens

import androidx.compose.animation.AnimatedContent
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.animation.with
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.aps.timerapp.R
import com.aps.timerapp.components.ScreenTitle
import com.aps.timerapp.components.bottombar.BottomBar
import com.aps.timerapp.domain.KeyPad
import com.aps.timerapp.domain.TimerContent
import com.aps.timerapp.domain.UiEvent

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun TimerScreen(
    timerViewModel: TimerViewModel
) {

    val timeState by remember {
        timerViewModel.timeState
    }
    val timerContent by remember {
        timerViewModel.timerContent
    }

    Column (
        modifier = Modifier
            .fillMaxSize()
            .background(colorResource(id = R.color.teal_200)),
    ) {
        ScreenTitle(title = "Timer")
        Spacer(modifier = Modifier.height(34.dp))
        AnimatedContent(
            targetState = timerContent,
            transitionSpec = {
                if(targetState == TimerContent.SELECTION) {
                    slideInVertically { height -> height } + fadeIn() with
                            slideOutVertically { height -> -height } + fadeOut()
                } else {
                    slideInVertically { height -> -height } + fadeIn() with
                            slideOutVertically { height -> height } + fadeOut()
                }
            }
        ) { target ->
            if (target == TimerContent.SELECTION) {
//                TimerSelectionScreen(
//                    modifier = Modifier.fillMaxWidth(),
//                    timeState = timeState,
//                    onKeyClick = { key ->
//                        timerViewModel.onEvent(
//                            UiEvent.OnKeyPressed(key)
//                        )
//                    }
//                )
            } else {
//                TimerRunnerScreen(
//                    modifier = Modifier.fillMaxWidth(),
//                    onTimerStop = { key ->
//                        timerViewModel.onEvent(
//                            UiEvent.OnKeyPressed(key)
//                        )
//                    }
//                )
            }
        }

        Box(modifier = Modifier
            .fillMaxHeight()
            .weight(1f),
            contentAlignment = Alignment.BottomCenter
        ) {
            BottomBar(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(80.dp)
                    .background(Color.LightGray),
                onTabClick = {
                    timerViewModel.onEvent(
                        UiEvent.OnKeyPressed(KeyPad.KeyPlay)
                    )
                }
            )
        }
        
    }
}