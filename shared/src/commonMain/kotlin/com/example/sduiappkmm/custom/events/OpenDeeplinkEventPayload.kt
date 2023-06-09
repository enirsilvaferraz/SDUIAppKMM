package com.example.sduiappkmm.custom.events

import com.example.sduiappkmm.core.models.PayloadDefinition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class OpenDeeplinkEventPayload(
    @SerialName("text") val text: String
) : PayloadDefinition