package com.example.sduiappkmm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sduiappkmm.core.PluginComponent
import com.example.sduiappkmm.core.SDUIUseCase
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.custom.payloads.TextComponentPayload
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.get
import org.koin.core.qualifier.named

object HelperKoin : KoinComponent {
    fun getUseCase() = get<SDUIUseCase>()

    fun getComponent(qualifier: String): PluginComponent<PayloadDefinition> = get(qualifier = named(qualifier))

    fun getJson() = get<Json>()
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    usecase: SDUIUseCase = HelperKoin.getUseCase()
) {

    println("Enir")
    val json = HelperKoin.getJson()
    println(json.decodeFromString<PayloadDefinition>( json.encodeToString(TextComponentPayload("A"))))

    MaterialTheme {
        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            usecase.run().forEach { it: PluginDefinition<PayloadDefinition> ->
                it.buildComponent()
            }
        }
    }
}

@Composable
fun <Payload : PayloadDefinition> PluginDefinition<Payload>.buildComponent() = HelperKoin.getComponent(this::class.simpleName!!).Build(this)

expect fun getPlatformName(): String