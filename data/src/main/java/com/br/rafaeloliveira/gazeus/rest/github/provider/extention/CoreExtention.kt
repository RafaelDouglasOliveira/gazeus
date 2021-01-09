package com.br.rafaeloliveira.gazeus.rest.github.provider.extention

import com.br.rafaeloliveira.gazeus.rest.github.data.di.DataModule
import com.br.rafaeloliveira.gazeus.rest.github.provider.InitProvider
import com.br.rafaeloliveira.gazeus.rest.github.provider.di.KoinInstance
import org.koin.android.ext.koin.androidContext
import org.koin.dsl.koinApplication

fun InitProvider.startKoinCore() {
    KoinInstance.KoinContext.koinApplication = koinApplication {
        androidContext(getAppContext())
        val modules = listOf(DataModule.loadDataModule())
        modules(modules)
    }
}