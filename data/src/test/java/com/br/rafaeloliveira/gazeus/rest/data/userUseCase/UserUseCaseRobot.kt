package com.br.rafaeloliveira.gazeus.rest.data.userUseCase

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Owner
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels.Repos
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.UserRepository
import com.br.rafaeloliveira.gazeus.rest.github.domain.userUseCase.UserUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.coVerify
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.junit.Assert.assertEquals
import kotlin.coroutines.CoroutineContext

fun withRobot(lb: UserUseCaseRobot.() -> Unit): UserUseCaseRobot =
    UserUseCaseRobot().apply(lb)

class UserUseCaseRobot {


    @MockK
    lateinit var mockRepositoryUser: UserRepository

    private var dispatcher: CoroutineContext = Dispatchers.Unconfined + SupervisorJob()
    var userUseCase: UserUseCase

    var success: Boolean? = null
    private val reposUser = Repos(
        id = 0,
        nodeId = "",
        fullName = "",
        name = "",
        private = false,
        owner  = Owner("teste")
    )

    private val listRepos = listOf(reposUser)


    init {
        MockKAnnotations.init(this)
        userUseCase = UserUseCase(mockRepositoryUser, dispatcher)
    }

    infix fun launch(lb: ActionRobot.() -> Unit) =
        ActionRobot(this).apply(lb)

    fun andWhenGetRepositoryReturnsSuccess() {
        coEvery { mockRepositoryUser.getRepositoryUser(any()) } returns listRepos
    }

    fun andWhenGetRepositoryRetunsError() {
        coEvery { mockRepositoryUser.getRepositoryUser(any()) }
    }
}

class ActionRobot(private val robot: UserUseCaseRobot) {

    infix fun check(lb: ResultRobot.() -> Unit) =
        ResultRobot(robot).apply(lb)

    fun getRepositoryNameUse(nameUser: String) {

        robot.userUseCase.getRepositoryUser(nameUser) { success, data ->

            robot.success = success


        }
    }

}

class ResultRobot(private val robot: UserUseCaseRobot) {

    fun thatGetRepositoryUserNameSuccess() {
        assertEquals(true, robot.success)
    }

    fun thatGetRepositoryUserNameError() {
        assertEquals(false, robot.success)
    }
}