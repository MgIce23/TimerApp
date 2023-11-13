package com.aps.timerapp.screens

import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.aps.timerapp.domain.KeyPad
import com.aps.timerapp.domain.TimerContent
import com.aps.timerapp.domain.UiEvent
import com.aps.timerapp.domain.model.TimeData
import com.aps.timerapp.domain.model.TimeUnit

class TimerViewModel : ViewModel(){

    var timeState = mutableStateOf(TimeData())
    var timerContent = mutableStateOf(TimerContent.SELECTION)

    fun onEvent(event: UiEvent){
        when(event){
            is UiEvent.OnKeyPressed -> {
                onPressKey(key = event.key)
            }
        }
    }

    private fun onPressKey(key: KeyPad){
        when(key){
            KeyPad.KeyPlay -> {
                timerContent.value = TimerContent.RUNNER
            }
            KeyPad.KeyDelete -> {
                if(timeState.value.isDataEmpty()){
                    return
                }
                deleteTime()
            }

            KeyPad.Key0 -> {
                if (timeState.value.isDataEmpty()
                    || timeState.value.isDataFul()
                )
                    return
                addTime(key.value)
            }
            KeyPad.Key00 -> {
                if (timeState.value.isDataEmpty()
                    || timeState.value.isHourHalfFull()
                    || timeState.value.isDataFul()
                ) return
                addTime(KeyPad.Key0.value)
                addTime(KeyPad.Key0.value)
            }

            KeyPad.KeyStop ->timerContent.value = TimerContent.SELECTION
            else ->{
                if (timeState.value.isDataFul())
                    return
                addTime(key.value)
            }
        }
    }

    private fun deleteTime() {
        val secs = TimeUnit(
            rightDigit = timeState.value.sec.leftDigit,
            leftDigit = timeState.value.mins.rightDigit)

        val mins = TimeUnit(
            rightDigit = timeState.value.mins.leftDigit,
            leftDigit = timeState.value.hour.rightDigit
        )

        val hour = TimeUnit(
            rightDigit = timeState.value.hour.leftDigit,
            leftDigit = 0
        )

        timeState.value = timeState.value.copy(
            hour = hour,
            mins = mins,
            sec = secs
        )
    }

    private fun addTime(value:String){
        val intValue = value.toInt()
        val hours = TimeUnit(
            leftDigit = timeState.value.hour.rightDigit,
            rightDigit = timeState.value.mins.leftDigit,
        )
        val mins = TimeUnit(
            leftDigit = timeState.value.mins.rightDigit,
            rightDigit = timeState.value.mins.leftDigit,
        )
        val secs = TimeUnit(
            leftDigit = timeState.value.sec.rightDigit,
            rightDigit = intValue,
        )
        timeState.value = timeState.value.copy(
            hour = hours,
            mins = mins,
            sec = secs
        )
    }


}