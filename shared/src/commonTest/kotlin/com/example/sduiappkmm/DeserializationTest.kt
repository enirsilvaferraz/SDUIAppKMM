package com.example.sduiappkmm

import kotlinx.serialization.json.Json
import kotlin.test.Test
import kotlin.test.assertEquals

class DeserializationTest {

    private val format = Json {
        coerceInputValues = true
        ignoreUnknownKeys = true
    }

    @Test
    fun `GIVEN a valid json WHEN I deserialize it THEN should return a POJO object`() {

        val json = "{\n" +
                "  \"pluginType\": \"NO1\",\n" +
                "  \"payload\": {\n" +
                "    \"text\": \"Text 1\"\n" +
                "  }\n" +
                "}"

//        val model = format.decodeFromString<PluginModel>(json)

//        assertEquals(model, PluginModel("NO1", "{\"text\":\"Text 1\"}", emptyList()))
    }

    @Test
    fun `GIVEN a valid json with plugins WHEN I deserialize it THEN should return a POJO object`() {

        val json = "[\n" +
                "  {\n" +
                "    \"pluginType\": \"N01\",\n" +
                "    \"payload\": {\n" +
                "      \"text\": \"Text 1\"\n" +
                "    }\n" +
                "  },\n" +
                "  {\n" +
                "    \"pluginType\": \"N02\",\n" +
                "    \"plugins\": [\n" +
                "      {\n" +
                "        \"pluginType\": \"N01\",\n" +
                "        \"payload\": {\n" +
                "          \"text\": \"Text 2\"\n" +
                "        }\n" +
                "      }\n" +
                "    ]\n" +
                "  }\n" +
                "]\n"

//        val model = format.decodeFromString<List<PluginModel>>(json)

//        assertEquals(model.size, 2)
//        assertEquals(model[0], PluginModel(pluginType = "N01", payload = "{\"text\":\"Text 1\"}"))
//        assertEquals(
//            model[1], PluginModel(
//                pluginType = "N02", plugins = listOf(
//                    PluginModel(
//                        pluginType = "N01",
//                        payload = "{\"text\":\"Text 2\"}"
//                    )
//                )
//            )
//        )
    }
}

