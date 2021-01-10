package com.br.rafaeloliveira.gazeus.rest.github.di

import com.br.rafaeloliveira.gazeus.rest.github.home.domain.repository.RepoUserRepository
import com.br.rafaeloliveira.gazeus.rest.github.home.domain.usecase.RepoUserUseCase
import com.br.rafaeloliveira.gazeus.rest.github.home.view.HomeViewModel
import com.br.rafaeloliveira.gazeus.rest.github.provider.CoreProvider
import org.koin.android.viewmodel.dsl.viewModel
import org.koin.dsl.module

object AppModules {

    private val modules = module {

        single { CoreProvider() }
        factory { RepoUserRepository(get()) }
        factory { RepoUserUseCase(get()) }
        viewModel {
            HomeViewModel(get())
        }
    }

    fun loadDomainModule() = modules
}