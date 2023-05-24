package com.example.sduiappkmm.custom.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sduiappkmm.core.Mapper
import com.example.sduiappkmm.core.PluginComponent
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition

class CardPluginComponent : PluginComponent {

    @Composable
    override fun Build(plugin: PluginDefinition<PayloadDefinition>) {
        Card(Modifier.padding(32.dp)) {
            Column {
                plugin.plugins.forEach {
                    Mapper.find(it::class)?.Build(it)
                }
            }
        }
    }
}