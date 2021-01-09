package com.br.rafaeloliveira.gazeus.rest.github.data.remote.api

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import retrofit2.http.GET
import retrofit2.http.Path

interface UserApi {

    @GET("users/{username}/repos")
    suspend fun getRepositoryUser(@Path("username") username : String) : List<Repos>
}