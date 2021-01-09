package com.br.rafaeloliveira.gazeus.rest.github.data.repository

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.api.UserApi

class UserRepository(private val userApi: UserApi) {

    suspend fun getRepositoryUser(nameUse : String) = userApi.getRepositoryUser(nameUse)
}