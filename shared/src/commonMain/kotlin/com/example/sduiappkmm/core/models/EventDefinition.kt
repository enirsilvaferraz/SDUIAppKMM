package com.example.sduiappkmm.core.models

interface EventDefinition<out Payload : PayloadDefinition> {
    val payload: Payload
}