package com.aps.timerapp.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.Backspace
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.aps.timerapp.domain.KeyPad

@Composable
fun TimerKeypadScreen(
    onKeyClick: (KeyPad) -> Unit
) {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier = Modifier
                .width(96.dp)
                .height(96.dp)
            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key1,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key2,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key3,
                onClick = onKeyClick
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier = Modifier
                .width(96.dp)
                .height(96.dp)
            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key4,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key5,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key6,
                onClick = onKeyClick
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier = Modifier
                .width(96.dp)
                .height(96.dp)
            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key7,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key8,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key9,
                onClick = onKeyClick
            )
        }

        Row(
            horizontalArrangement = Arrangement.spacedBy(24.dp)
        ) {
            val modifier = Modifier
                .width(96.dp)
                .height(96.dp)
            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key00,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.Key0,
                onClick = onKeyClick
            )

            CircularKey(
                modifier = modifier,
                keypad = KeyPad.KeyDelete,
                backgroundColor = Color.Blue,
                icon = Icons.Outlined.Backspace,
                textColor = Color.Magenta,
                onClick = onKeyClick
            )
        }
    }
}

@Preview
@Composable
fun TimerKeyPad(){
    TimerKeypadScreen(onKeyClick = {})
}