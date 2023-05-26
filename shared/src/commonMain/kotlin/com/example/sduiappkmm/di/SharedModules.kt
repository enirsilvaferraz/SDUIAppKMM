package com.example.sduiappkmm.di

import com.example.sduiappkmm.core.PluginComponent
import com.example.sduiappkmm.core.SDUIRepository
import com.example.sduiappkmm.core.SDUIUseCase
import com.example.sduiappkmm.custom.components.CardPluginComponent
import com.example.sduiappkmm.custom.components.TextPluginComponent
import com.example.sduiappkmm.custom.plugins.CardPluginDefinition
import com.example.sduiappkmm.custom.plugins.TextPluginDefinition
import kotlinx.serialization.json.Json
import org.koin.core.context.startKoin
import org.koin.core.qualifier.named
import org.koin.dsl.bind
import org.koin.dsl.module

object SharedModules {

    val moduleDef = module {
        single { Json {
            serializersModule = module1 //+ module2
            ignoreUnknownKeys = true
            coerceInputValues = true
        } } bind Json::class
        factory { SDUIUseCase(repository = get()) }
        factory { SDUIRepository(jsonBuilder = get()) }

        factory(named(CardPluginDefinition::class.simpleName!!)) { CardPluginComponent() } bind PluginComponent::class
        factory(named(TextPluginDefinition::class.simpleName!!)) { TextPluginComponent() } bind PluginComponent::class
    }
}

fun initKoin() {
    startKoin {
        modules(SharedModules.moduleDef)
    }
}