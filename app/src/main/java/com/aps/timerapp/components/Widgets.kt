package com.aps.timerapp.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.aps.timerapp.domain.KeyPad
import com.aps.timerapp.domain.model.TimeData
import com.aps.timerapp.domain.model.TimeUnit

@Composable
fun TimeUnit(
    time: TimeUnit = TimeUnit(),
    unit:String,
    textColor: Color = Color.Gray
    ){

}

@Composable
fun CircularKey(
    keypad: KeyPad,
    modifier: Modifier = Modifier,
    backgroundColor: Color = Color.LightGray,
    textColor: Color = Color.Gray,
    icon : ImageVector? = null,
    onClick: (KeyPad) -> Unit
){
    Box(
        contentAlignment = Alignment.Center,
        modifier = Modifier
            .clip(RoundedCornerShape(100.dp))
            .background(backgroundColor)
            .clickable {
                onClick(keypad)
            }
            .then(modifier),
    ) {
        if (icon != null) {
            Icon(
                icon,
                modifier = Modifier.size(22.dp),
                contentDescription = "Delete",
                tint = textColor
            )
        } else {
            Text(
                keypad.value,
                style = TextStyle(
                    color = textColor,
                    fontSize = 34.sp,
                ),
            )
        }
    }

}


@Composable
fun ScreenTitle(
    title: String,
) {
    Text(
        text = title,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp),
        style = TextStyle(
            color = Color.Gray,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            textAlign = TextAlign.Start
        )
    )
}

@Composable
fun TimeDisplay(
    time: TimeData = TimeData(),
) {

    val timeUnitColor  = if (time.isDataEmpty()) Color.Gray else Color.Blue

    Row(
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        TimeDisplayUnit(
            time = time.hour,
            unit = "h",
            textColor = timeUnitColor
        )

        TimeDisplayUnit(
            time = time.mins,
            unit = "m",
            textColor = timeUnitColor
        )

        TimeDisplayUnit(
            time = time.sec,
            unit = "s",
            textColor = timeUnitColor
        )
    }
}

@Composable
fun TimeDisplayUnit(
    time: TimeUnit = TimeUnit(),
    unit: String,
    textColor: Color = Color.Gray
) {

    Row(
        modifier = Modifier.wrapContentSize(),
        verticalAlignment = Alignment.Bottom
    ) {
        Text(
            text = "${time.leftDigit}",
            modifier = Modifier.alignByBaseline(),
            style = TextStyle(
                fontSize = 65.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
            )
        )
        Text(
            text = "${time.rightDigit}",
            modifier = Modifier.alignByBaseline(),
            style = TextStyle(
                fontSize = 65.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
            ),
        )
        Text(
            text = unit,
            modifier = Modifier.alignByBaseline(),
            style = TextStyle(
                fontSize = 24.sp,
                fontWeight = FontWeight.Medium,
                color = textColor,
            ),
        )
    }
}
