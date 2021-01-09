package com.br.rafaeloliveira.gazeus.rest.data.userUseCase

import org.junit.Test

class UserCaseTest {

    private val nameUser = "Teste"

    @Test
    fun `get repository name user with success`() {

        withRobot {
            andWhenGetRepositoryReturnsSuccess()
        } launch {
            getRepositoryNameUse(nameUser)
        }check {
            thatGetRepositoryUserNameSuccess()
        }
    }

    @Test
    fun `get repository name user with error`() {

        withRobot {
            andWhenGetRepositoryRetunsError()
        } launch {
            getRepositoryNameUse(nameUser)
        }check {
            thatGetRepositoryUserNameError()
        }
    }
}