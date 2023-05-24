package com.example.sduiappkmm.custom.plugins

import com.example.sduiappkmm.core.models.PayloadDefinition
import kotlinx.serialization.Serializable

@Serializable
data class TextComponentPayload(val text: String) : PayloadDefinition