package com.br.rafaeloliveira.gazeus.rest.github.home.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.br.rafaeloliveira.gazeus.rest.github.home.domain.usecase.RepoUserUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.launch
import kotlin.coroutines.CoroutineContext

class HomeViewModel(
    private val repoUserUseCase: RepoUserUseCase,
    private val dispatcher : CoroutineContext = Dispatchers.Main + SupervisorJob()
) : ViewModel() {

    private val mutableHomeCommand = MutableLiveData<HomeCommand>()
    val command: LiveData<HomeCommand> = mutableHomeCommand


    fun getRepoNameUser(nameUser : String) {

         viewModelScope.launch(dispatcher) {

             repoUserUseCase.invoke(nameUser) { success , data ->

                 if(success) {
                     HomeCommand.SuccessQueryRepo(data).run()
                 } else {
                     HomeCommand.ErrorQueryRepo.run()
                 }
             }
         }
    }

    private fun HomeCommand.run() {
        mutableHomeCommand.postValue(this)
    }
}