package com.example.sduiappkmm.custom.events

import com.example.sduiappkmm.core.models.EventDefinition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("deeplink-event")
data class OpenDeeplinkEventDefinition(
    @SerialName("payload") override val payload: OpenDeeplinkEventPayload
) : EventDefinition<OpenDeeplinkEventPayload>