package com.example.sduiappkmm.core

import com.example.sduiappkmm.core.models.PluginDefinition
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.builtins.ListSerializer
import kotlinx.serialization.json.Json

class SDUIRepository(private val jsonBuilder: Json) {

    private val json =
        "[{\"type\":\"card-component\",\"payload\":{},\"plugins\":[{\"type\":\"text-component\",\"payload\":{\"text\":\"A\"}},{\"type\":\"text-component\",\"payload\":{\"text\":\"B\"}},{\"type\":\"text-component\",\"payload\":{\"text\":\"C\"}}]}]"

    fun run() = jsonBuilder.decodeFromString(ListSerializer(PolymorphicSerializer(PluginDefinition::class)), json)
}