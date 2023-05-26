package com.example.sduiappkmm

import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.coreimpl.models.EmptyPayload
import com.example.sduiappkmm.custom.events.OpenDeeplinkEventDefinition
import com.example.sduiappkmm.custom.events.OpenDeeplinkEventPayload
import com.example.sduiappkmm.custom.payloads.TextComponentPayload
import com.example.sduiappkmm.custom.plugins.CardPluginDefinition
import com.example.sduiappkmm.custom.plugins.TextPlugin2Definition
import com.example.sduiappkmm.custom.plugins.TextPluginDefinition
import com.example.sduiappkmm.di.format
import kotlinx.serialization.PolymorphicSerializer
import kotlinx.serialization.encodeToString
import kotlin.test.Test

class TypeTest {


    @Test
    fun test() {

        val definition = TextPluginDefinition(
            payload = TextComponentPayload(text = "A"),
            plugins = listOf(
                TextPluginDefinition(payload = TextComponentPayload(text = "B"), plugins = emptyList(), events = emptyList())
            ),
            events = listOf(
                OpenDeeplinkEventDefinition(payload = OpenDeeplinkEventPayload(text = "deeplink"))
            )
        )

        val encodeToString = format.encodeToString(PolymorphicSerializer(PluginDefinition::class), definition)
        println(encodeToString)

        val decodeFromString = format.decodeFromString(PolymorphicSerializer(PluginDefinition::class), encodeToString)
        println(decodeFromString)
    }

    @Test
    fun test2() {

        val definition = TextPluginDefinition(
            payload = TextComponentPayload(text = "A"),
            plugins = listOf(
                TextPlugin2Definition(payload = TextComponentPayload(text = "B"), plugins = emptyList(), events = emptyList())
            ),
            events = emptyList()
        )


        val encodeToString = format.encodeToString(definition)
        println(encodeToString)

        val decodeFromString = format.decodeFromString(PolymorphicSerializer(PluginDefinition::class), encodeToString)
        println(decodeFromString)
    }

    @Test
    fun test3() {

        val json =
            "[{\"type\":\"text-component2\",\"payload\":{\"text\":\"A\"},\"plugins\":[{\"type\":\"text-component\",\"payload\":{\"text\":\"B\"},\"plugins\":[],\"events\":[]}],\"events\":[]}]"

        val decodeFromString = format.decodeFromString<List<PluginDefinition<PayloadDefinition>>>(json)
        println(decodeFromString)
    }


    @Test
    fun test4() {

        val definition = listOf(
            // UnknownPlugin(),
//            TextPlugin2Definition(payload = TextComponentPayload(text = "B"))
            CardPluginDefinition(
                payload = EmptyPayload, plugins = listOf(
                    TextPluginDefinition(payload = TextComponentPayload(text = "A")),
                    TextPluginDefinition(payload = TextComponentPayload(text = "B")),
                    TextPluginDefinition(payload = TextComponentPayload(text = "C"))
                )
            )
        )

        format.encodeToString(definition).also {
            println(it)
        }
    }
}

//[{"type":"text-component","payload":{"text":"A"},"plugins":[{"type":"text-component2","payload":{"text":"B"},"plugins":[],"events":[]}],"events":[]}]