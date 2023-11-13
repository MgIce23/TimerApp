package com.aps.timerapp.domain

sealed class KeyPad(val value:String){
    object Key1: KeyPad("1")
    object Key2: KeyPad("2")
    object Key3: KeyPad("3")
    object Key4: KeyPad("4")
    object Key5: KeyPad("5")
    object Key6: KeyPad("6")
    object Key7: KeyPad("7")
    object Key8: KeyPad("8")
    object Key9: KeyPad("9")
    object Key0: KeyPad("0")
    object Key00:KeyPad("00")
    object KeyDelete: KeyPad("x")
    object KeyPlay: KeyPad("play")
    object KeyStop: KeyPad("stop")
}