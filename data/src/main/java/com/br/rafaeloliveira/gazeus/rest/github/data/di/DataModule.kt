package com.br.rafaeloliveira.gazeus.rest.github.data.di

import androidx.annotation.Keep
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.RetrofitServiceProvider
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.api.TagApi
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.api.UserApi
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.TagRepository
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.UserRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module

@Keep
object DataModule {

    private val data = module {

        factory {
            RetrofitServiceProvider(androidApplication())
        }

        factory { get<RetrofitServiceProvider>().create(UserApi::class.java) }
        factory { get<RetrofitServiceProvider>().create(TagApi::class.java) }
        factory { UserRepository(get()) }
        factory { TagRepository(get()) }
    }

    fun loadDataModule() = data
}