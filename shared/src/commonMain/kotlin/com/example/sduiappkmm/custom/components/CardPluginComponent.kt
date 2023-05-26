package com.example.sduiappkmm.custom.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sduiappkmm.buildComponent
import com.example.sduiappkmm.core.PluginComponent
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.coreimpl.models.EmptyPayload

class CardPluginComponent : PluginComponent<EmptyPayload> {

    @Composable
    override fun Build(plugin: PluginDefinition<EmptyPayload>) {
        Card(Modifier.padding(32.dp)) {
            Column {
                plugin.plugins.forEach {
                    it.buildComponent()
                }
            }
        }
    }
}