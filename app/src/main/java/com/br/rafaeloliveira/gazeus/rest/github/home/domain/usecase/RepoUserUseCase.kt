package com.br.rafaeloliveira.gazeus.rest.github.home.domain.usecase

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.home.domain.repository.RepoUserRepository

class RepoUserUseCase(private val repoUserRepository: RepoUserRepository) {

    operator fun invoke(nameUser : String , callBack : (Boolean ,List<Repos>? ) -> Unit) {

        repoUserRepository.getRepoUserName(nameUser){success, data ->

            callBack(success, data)
        }


    }

}