package com.br.rafaeloliveira.gazeus.rest.github.provider

import androidx.annotation.Keep
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.domain.userUseCase.UserUseCase
import com.br.rafaeloliveira.gazeus.rest.github.provider.di.CustomKoinComponent
import org.koin.android.ext.android.inject


@Keep
class CoreProvider : InitProvider(), CustomKoinComponent {

    private val userUseCase by inject<UserUseCase>()

    fun getRepositoryUserName(
        nameUser: String,
        callBack: (success: Boolean, data: List<Repos>?) -> Unit
    ) = userUseCase.getRepositoryUser(nameUser, callBack)

}