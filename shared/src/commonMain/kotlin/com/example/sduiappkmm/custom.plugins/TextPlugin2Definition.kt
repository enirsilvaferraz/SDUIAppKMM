package com.example.sduiappkmm.custom.plugins

import com.example.sduiappkmm.core.models.EventDefinition
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.custom.payloads.TextComponentPayload
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("text-component2")
data class TextPlugin2Definition(
    @SerialName("payload") override val payload: TextComponentPayload,
    @SerialName("plugins") override val plugins: List<PluginDefinition<PayloadDefinition>> = emptyList(),
    @SerialName("events") override val events: List<EventDefinition<PayloadDefinition>> = emptyList()
) : PluginDefinition<TextComponentPayload>
