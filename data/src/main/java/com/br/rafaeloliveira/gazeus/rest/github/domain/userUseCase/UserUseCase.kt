package com.br.rafaeloliveira.gazeus.rest.github.domain.userUseCase

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.SafeResponse
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.safeRequest
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.UserRepository
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class UserUseCase(private val userRepository: UserRepository,
                   dispatcher: CoroutineContext = Dispatchers.IO + SupervisorJob()
                  ) {


    private var coroutinesScope = CoroutineScope(dispatcher)

    fun getRepositoryUser(nameUse : String,
                            callback : (code : Boolean, data : List<Repos>?) -> Unit){

        coroutinesScope.launch {
            when(val response = safeRequest {
                userRepository.getRepositoryUser(nameUse)

            }) {
                is SafeResponse.Success -> callback(true, response.value)
                is SafeResponse.NetworkError -> callback(false, null)
            }
        }
    }
}