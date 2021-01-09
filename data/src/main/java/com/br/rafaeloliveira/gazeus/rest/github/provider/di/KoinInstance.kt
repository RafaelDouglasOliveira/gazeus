package com.br.rafaeloliveira.gazeus.rest.github.provider.di

import org.koin.core.KoinApplication

class KoinInstance {

    object KoinContext {
        lateinit var koinApplication: KoinApplication
    }
}