package com.example.sduiappkmm.di

import com.example.sduiappkmm.core.SDUIRepository
import com.example.sduiappkmm.core.SDUIUseCase
import org.koin.core.context.startKoin
import org.koin.dsl.module

object SharedModules {

    val moduleDef = module {
        single { format }
        factory { SDUIUseCase(repository = get()) }
        factory { SDUIRepository(jsonBuilder = get()) }
    }
}

fun initKoin() {
    startKoin {
        modules(SharedModules.moduleDef)
    }
}