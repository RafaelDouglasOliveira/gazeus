package com.br.rafaeloliveira.gazeus.rest.github.data.remote.api

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.tagModels.TagRepo
import retrofit2.http.GET
import retrofit2.http.Path

interface TagApi {

    @GET("repos/{owner}/{repo}/tags")
    suspend fun getRepositoryTag(@Path("owner")  owner : String,
                                 @Path("repo") repo : String
                                 ) : List<TagRepo>
}