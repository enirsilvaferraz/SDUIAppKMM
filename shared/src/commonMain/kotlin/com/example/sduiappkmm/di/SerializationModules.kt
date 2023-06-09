package com.example.sduiappkmm.di

import com.example.sduiappkmm.core.models.EventDefinition
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.coreimpl.models.EmptyPayload
import com.example.sduiappkmm.custom.events.OpenDeeplinkEventDefinition
import com.example.sduiappkmm.custom.events.OpenDeeplinkEventPayload
import com.example.sduiappkmm.custom.payloads.TextComponentPayload
import com.example.sduiappkmm.custom.plugins.CardPluginDefinition
import com.example.sduiappkmm.custom.plugins.TextPlugin2Definition
import com.example.sduiappkmm.custom.plugins.TextPluginDefinition
import com.example.sduiappkmm.custom.plugins.UnknownPluginDefinition
import kotlinx.serialization.KSerializer
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlinx.serialization.modules.SerializersModuleBuilder
import kotlinx.serialization.serializer
import kotlin.native.concurrent.SharedImmutable
import kotlin.reflect.KClass

@SharedImmutable
val module1 = SerializersModule {

    /**
     * Plugins
     */
    plugin(clazz = TextPluginDefinition::class, serializer = serializer())
    plugin(clazz = CardPluginDefinition::class, serializer = serializer())
    plugin(clazz = UnknownPluginDefinition::class, serializer = serializer())
    defaultPlugin(serializer = UnknownPluginDefinition.serializer())

    /**
     * Events
     */

    event(clazz = OpenDeeplinkEventDefinition::class, serializer = serializer())

    /**
     * Payloads
     */

    payload(clazz = OpenDeeplinkEventPayload::class, serializer = serializer())
    payload(clazz = TextComponentPayload::class, serializer = serializer())
    payload(clazz = EmptyPayload::class, serializer = serializer())
}

@SharedImmutable
val module2 = SerializersModule {
    plugin(clazz = TextPlugin2Definition::class, serializer = serializer())
}

val format = Json {
    serializersModule = module1 //+ module2
    ignoreUnknownKeys = true
    coerceInputValues = true
}

inline fun <T : PluginDefinition<PayloadDefinition>> SerializersModuleBuilder.plugin(clazz: KClass<T>, serializer: KSerializer<T>) {
    polymorphic(baseClass = PluginDefinition::class, actualClass = clazz, actualSerializer = serializer)
}

inline fun <T : PluginDefinition<PayloadDefinition>> SerializersModuleBuilder.defaultPlugin(serializer: KSerializer<T>) {
    polymorphicDefaultDeserializer(baseClass = PluginDefinition::class, defaultDeserializerProvider = { serializer })
}

inline fun <T : EventDefinition<PayloadDefinition>> SerializersModuleBuilder.event(clazz: KClass<T>, serializer: KSerializer<T>) {
    polymorphic(baseClass = EventDefinition::class, actualClass = clazz, actualSerializer = serializer)
}

inline fun <T : PayloadDefinition> SerializersModuleBuilder.payload(clazz: KClass<T>, serializer: KSerializer<T>) {
    polymorphic(baseClass = PayloadDefinition::class, actualClass = clazz, actualSerializer = serializer)
}
