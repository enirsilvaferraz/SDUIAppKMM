package com.example.sduiappkmm

import kotlinx.serialization.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.modules.SerializersModule
import kotlin.test.Test
import kotlin.test.assertEquals

class NewTestType {

    @Test
    fun testDecode() {

        val json = "{\"type\": \"C\"}"

        val aClazz = format.decodeFromString<A>(json)

        assertEquals(aClazz, C())
        println(aClazz)
    }

    @Test
    fun testEncode() {
        val model = C()
        format.encodeToString<A>(model).also {
            println(it)
        }
    }
}

val format = Json {
    serializersModule = SerializersModule {
        polymorphic(baseClass = A::class, actualClass = B::class, actualSerializer = B.serializer())
        polymorphic(baseClass = A::class, actualClass = C::class, actualSerializer = C.serializer())
        polymorphicDefaultDeserializer(baseClass = A::class, defaultDeserializerProvider = { C.serializer() })
    }
    encodeDefaults = true
    ignoreUnknownKeys = true
}

interface A

@Serializable
@SerialName("B")
data class B(val name: String? = null) : A

@Serializable
data class C(val name: String? = null) : A
