package com.aps.timerapp.domain

sealed class UiEvent{
    data class OnKeyPressed(val key:KeyPad): UiEvent()
}
