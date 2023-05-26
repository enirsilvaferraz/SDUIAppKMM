package com.example.sduiappkmm.core

import androidx.compose.runtime.Composable
import com.example.sduiappkmm.core.models.PayloadDefinition
import com.example.sduiappkmm.core.models.PluginDefinition

interface PluginComponent<T : PayloadDefinition> {

    @Composable
    fun Build(plugin: PluginDefinition<T>)
}