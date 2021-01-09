package com.br.rafaeloliveira.gazeus.rest.github.provider.di

import android.app.Application
import org.koin.core.KoinApplication

class KoinInstance {

    object KoinContext {
        lateinit var koinApplication: KoinApplication
    }
}