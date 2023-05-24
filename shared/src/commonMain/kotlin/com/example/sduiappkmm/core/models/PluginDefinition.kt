package com.example.sduiappkmm.core.models

interface PluginDefinition<out Payload : PayloadDefinition> {
    val payload: Payload
    val plugins: List<PluginDefinition<PayloadDefinition>>
    val events: List<EventDefinition<PayloadDefinition>>
}