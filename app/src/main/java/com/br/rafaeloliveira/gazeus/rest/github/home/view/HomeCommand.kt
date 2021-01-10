package com.br.rafaeloliveira.gazeus.rest.github.home.view

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos

sealed class HomeCommand {
    class SuccessQueryRepo(val items: List<Repos>?) : HomeCommand()
    object ErrorQueryRepo : HomeCommand()
}