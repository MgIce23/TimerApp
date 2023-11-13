package com.aps.timerapp.components.bottombar

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.AccessTime
import androidx.compose.material.icons.outlined.AirlineSeatIndividualSuite
import androidx.compose.material.icons.outlined.Alarm
import androidx.compose.material.icons.outlined.HourglassBottom
import androidx.compose.material.icons.outlined.Timer
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun BottomBar(
    modifier: Modifier,
    onTabClick: () -> Unit
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.SpaceAround,
        verticalAlignment = Alignment.CenterVertically
    ) {
        val modifier = Modifier.weight(1f)
        BottomTab(
            modifier = modifier,
            title = "Alarm",
            icon = Icons.Outlined.Alarm,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Clock",
            icon = Icons.Outlined.AccessTime,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Timer",
            icon = Icons.Outlined.HourglassBottom,
            isSelected = true,
            onClick = {
                onTabClick()
            }
        )
        BottomTab(
            modifier = modifier,
            title = "Stopwatch",
            icon = Icons.Outlined.Timer,
            onClick = {}
        )
        BottomTab(
            modifier = modifier,
            title = "Bedtime",
            icon = Icons.Outlined.AirlineSeatIndividualSuite,
            onClick = {}
        )
    }
}