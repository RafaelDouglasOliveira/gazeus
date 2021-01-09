package com.br.rafaeloliveira.gazeus.rest.github.domain.tagUseCase

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.SafeResponse
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.safeRequest
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.tagModels.TagRepo
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.TagRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class TagUseCase(private val tagRepository: TagRepository,
                 dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()
)  {

    private var coroutinesScope = CoroutineScope(dispatcher)

    fun getTagRepoOwner(owner: String,
                        repo : String,
                          callback : (code : Boolean, data : List<TagRepo>?) -> Unit) {

        coroutinesScope.launch {

            when(val response = safeRequest {
                tagRepository.getTagRepoOwner(owner, repo)

            }) {

                is SafeResponse.Success -> callback(true, response.value)
                is SafeResponse.GenericError -> callback(false , null)
                is SafeResponse.NetworkError -> callback(false , null)
            }
        }
    }
}