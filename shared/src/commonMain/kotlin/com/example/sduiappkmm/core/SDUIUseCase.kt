package com.example.sduiappkmm.core

import com.example.sduiappkmm.custom.plugins.UnknownPluginDefinition

class SDUIUseCase(private val repository: SDUIRepository) {

    fun run() = repository.run().filterNot { it is UnknownPluginDefinition }
}

