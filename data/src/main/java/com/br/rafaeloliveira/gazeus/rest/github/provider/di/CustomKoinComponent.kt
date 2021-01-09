package com.br.rafaeloliveira.gazeus.rest.github.provider.di

import org.koin.core.Koin
import org.koin.core.KoinComponent

interface CustomKoinComponent : KoinComponent {

    override fun getKoin(): Koin = KoinInstance.KoinContext.koinApplication.koin


}