package com.example.sduiappkmm.custom.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.sduiappkmm.core.PluginComponent
import com.example.sduiappkmm.core.models.PluginDefinition
import com.example.sduiappkmm.custom.payloads.TextComponentPayload

class TextPluginComponent : PluginComponent<TextComponentPayload> {

    @Composable
    override fun Build(plugin: PluginDefinition<TextComponentPayload>) {
        Text(text = plugin.payload.text, fontSize = 20.sp, modifier = Modifier.padding(8.dp))
    }
}