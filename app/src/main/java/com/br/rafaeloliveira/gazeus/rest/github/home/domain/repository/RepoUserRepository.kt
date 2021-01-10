package com.br.rafaeloliveira.gazeus.rest.github.home.domain.repository

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.provider.CoreProvider

class RepoUserRepository(private val coreProvider: CoreProvider) {


    fun getRepoUserName(nameUser: String ,
                        callback: (Boolean, List<Repos>?) -> Unit
                        ) = coreProvider.getRepositoryUserName(nameUser, callback)



}