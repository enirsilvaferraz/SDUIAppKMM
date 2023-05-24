package com.example.sduiappkmm.core

import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import kotlinx.serialization.json.Json

class SDUIRepository(private val jsonBuilder: Json) {

    private val json = "[{\"type\":\"card-component\",\"payload\":{},\"plugins\":[{\"type\":\"text-component\",\"payload\":{\"text\":\"A\"}},{\"type\":\"text-component\",\"payload\":{\"text\":\"B\"}},{\"type\":\"text-component\",\"payload\":{\"text\":\"C\"}}]}]"

    fun run() = jsonBuilder.decodeFromString<List<PluginDefinition<PayloadDefinition>>>(json.trim())
}