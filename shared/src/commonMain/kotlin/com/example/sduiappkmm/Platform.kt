package com.example.sduiappkmm

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform