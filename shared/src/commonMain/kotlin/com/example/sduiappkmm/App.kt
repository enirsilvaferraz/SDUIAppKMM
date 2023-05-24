package com.example.sduiappkmm

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.example.sduiappkmm.core.Mapper
import com.example.sduiappkmm.core.SDUIUseCase
import org.jetbrains.compose.resources.ExperimentalResourceApi
import org.koin.core.component.KoinComponent
import org.koin.core.component.get

object HelperKoin : KoinComponent {
    fun getUseCase() = get<SDUIUseCase>()
}

@OptIn(ExperimentalResourceApi::class)
@Composable
fun App(
    usecase: SDUIUseCase = HelperKoin.getUseCase()
) {
    MaterialTheme {

        Column(Modifier.fillMaxWidth(), horizontalAlignment = Alignment.CenterHorizontally) {
            usecase.run().forEach {
                Mapper.find(it::class)?.Build(it)
            }
        }
    }
}

expect fun getPlatformName(): String