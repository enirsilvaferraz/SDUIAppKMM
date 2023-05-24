package com.example.sduiappkmm.custom.events

import com.example.sduiappkmm.core.models.PayloadDefinition
import kotlinx.serialization.Serializable

@Serializable
data class OpenDeeplinkEventPayload(val text: String) : PayloadDefinition