package com.example.sduiappkmm.custom.plugins

import com.example.sduiappkmm.core.models.EventDefinition
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.coreimpl.models.EmptyPayload
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class UnknownPluginDefinition(
    @SerialName("payload") override val payload: EmptyPayload,
    @SerialName("plugins") override val plugins: List<PluginDefinition<PayloadDefinition>> = emptyList(),
    @SerialName("events") override val events: List<EventDefinition<PayloadDefinition>> = emptyList()
) : PluginDefinition<EmptyPayload>