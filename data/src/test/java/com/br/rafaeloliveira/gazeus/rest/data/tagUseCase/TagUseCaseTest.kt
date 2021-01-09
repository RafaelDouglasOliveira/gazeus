package com.br.rafaeloliveira.gazeus.rest.data.tagUseCase

import org.junit.Test

class TagUseCaseTest {

    private val repoName = "Teste"
    private val owner = "Teste"

    @Test
    fun `get repository  tag with success`() {

        withRobot {
            andWhenGetRepositoryTagReturnsSuccess()
        } launch {
            getRepositoryTagOwner(owner,repoName)
        }check {
            thatGetRepositoryTagSuccess()
        }

    }

    @Test
    fun `get repository tag  with error`() {

        withRobot {
            andWhenGetTagRepositoryRetunsError()
        } launch {
            getRepositoryTagOwner(owner,repoName)
        }check {
            thatGetRepositoryTagError()
        }
    }
}