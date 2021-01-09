package com.br.rafaeloliveira.gazeus.rest.github.data.di

import androidx.annotation.Keep
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.RetrofitServiceProvider
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.api.UserApi
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.UserRepository
import org.koin.dsl.module

@Keep
object DataModule {

    private val data = module {

        factory { get<RetrofitServiceProvider>().create(UserApi::class.java) }
        factory { UserRepository(get()) }
    }

    fun loadDataModule() = data
}