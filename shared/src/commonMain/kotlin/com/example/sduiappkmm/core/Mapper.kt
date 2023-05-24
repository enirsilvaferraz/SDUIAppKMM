package com.example.sduiappkmm.core

import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.custom.components.CardPluginComponent
import com.example.sduiappkmm.custom.components.TextPluginComponent
import com.example.sduiappkmm.custom.plugins.CardPluginDefinition
import com.example.sduiappkmm.custom.plugins.TextPluginDefinition
import kotlin.reflect.KClass

object Mapper {

    val map = mapOf(
        TextPluginDefinition::class to TextPluginComponent(),
        CardPluginDefinition::class to CardPluginComponent()
    )

    inline fun find(clazz: KClass<out PluginDefinition<PayloadDefinition>>) = map[clazz]
}