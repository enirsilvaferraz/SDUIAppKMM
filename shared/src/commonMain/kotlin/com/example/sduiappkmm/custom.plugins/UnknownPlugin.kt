package com.example.sduiappkmm.custom.plugins

import com.example.sduiappkmm.core.models.EmptyPayload
import com.example.sduiappkmm.core.models.EventDefinition
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import kotlinx.serialization.Serializable

@Serializable
class UnknownPlugin : PluginDefinition<EmptyPayload> {
    override val payload: EmptyPayload = EmptyPayload
    override val plugins: List<PluginDefinition<PayloadDefinition>> = emptyList()
    override val events: List<EventDefinition<PayloadDefinition>> = emptyList()
}