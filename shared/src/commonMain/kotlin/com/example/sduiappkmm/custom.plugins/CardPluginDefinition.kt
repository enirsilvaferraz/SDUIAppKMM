package com.example.sduiappkmm.custom.plugins

import com.example.sduiappkmm.core.models.EmptyPayload
import com.example.sduiappkmm.core.models.EventDefinition
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
@SerialName("card-component")
class CardPluginDefinition(
    override val payload: EmptyPayload,
    override val plugins: List<PluginDefinition<PayloadDefinition>> = emptyList(),
    override val events: List<EventDefinition<PayloadDefinition>> = emptyList()
) : PluginDefinition<EmptyPayload>