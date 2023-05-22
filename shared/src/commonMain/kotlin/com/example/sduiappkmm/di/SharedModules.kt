package com.example.sduiappkmm.di

import org.koin.core.context.startKoin
import org.koin.dsl.module

object SharedModules {

    val moduleDef = module {

    }
}

fun initKoin() {
    startKoin {
        modules(SharedModules.moduleDef)
    }
}