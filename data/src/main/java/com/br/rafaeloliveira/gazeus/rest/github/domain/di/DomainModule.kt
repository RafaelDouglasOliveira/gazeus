package com.br.rafaeloliveira.gazeus.rest.github.domain.di

import androidx.annotation.Keep
import com.br.rafaeloliveira.gazeus.rest.github.domain.tagUseCase.TagUseCase
import com.br.rafaeloliveira.gazeus.rest.github.domain.userUseCase.UserUseCase
import org.koin.dsl.module

@Keep
object DomainModule {

    private val domain = module{

        factory { UserUseCase(get()) }
        factory { TagUseCase(get()) }
    }

    fun loadDomainModule() = domain
}