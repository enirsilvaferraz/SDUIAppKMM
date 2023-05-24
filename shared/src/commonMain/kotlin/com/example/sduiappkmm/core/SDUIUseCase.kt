package com.example.sduiappkmm.core

class SDUIUseCase(private val repository: SDUIRepository) {

    fun run() = repository.run()
}

