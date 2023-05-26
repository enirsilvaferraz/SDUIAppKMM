package com.example.sduiappkmm.custom.payloads

import com.example.sduiappkmm.core.models.PayloadDefinition
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class TextComponentPayload(@SerialName("text") val text: String) : PayloadDefinition