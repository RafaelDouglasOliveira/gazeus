package com.br.rafaeloliveira.gazeus.rest.github.data.repository

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.api.TagApi

class TagRepository (private val tagApi: TagApi) {

    suspend fun getTagRepoOwner(owner: String , repo : String ) = tagApi.getRepositoryTag(owner, repo)
}