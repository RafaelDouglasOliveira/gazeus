package com.br.rafaeloliveira.gazeus.rest.github.provider

import androidx.annotation.Keep
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.tagModels.TagRepo
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.domain.tagUseCase.TagUseCase
import com.br.rafaeloliveira.gazeus.rest.github.domain.userUseCase.UserUseCase
import com.br.rafaeloliveira.gazeus.rest.github.provider.di.CustomKoinComponent
import org.koin.android.ext.android.inject


@Keep
class CoreProvider : InitProvider(), CustomKoinComponent {

    private val userUseCase by inject<UserUseCase>()
    private val tagUseCase by inject<TagUseCase>()

    fun getRepositoryUserName(
        nameUser: String,
        callBack: (success: Boolean, data: List<Repos>?) -> Unit
    ) = userUseCase.getRepositoryUser(nameUser, callBack)

    fun getTagOwnerRepo(owner: String,
                        repo : String,
                        callBack: (success: Boolean, data: List<TagRepo>?) -> Unit
    ) = tagUseCase.getTagRepoOwner(owner,repo, callBack)

}