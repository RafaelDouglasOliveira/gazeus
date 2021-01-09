package com.br.rafaeloliveira.gazeus.rest.data.tagUseCase

import com.br.rafaeloliveira.gazeus.rest.github.data.remote.tagModels.Commit
import com.br.rafaeloliveira.gazeus.rest.github.data.remote.tagModels.TagRepo
import com.br.rafaeloliveira.gazeus.rest.github.data.repository.TagRepository
import com.br.rafaeloliveira.gazeus.rest.github.domain.tagUseCase.TagUseCase
import io.mockk.MockKAnnotations
import io.mockk.coEvery
import io.mockk.impl.annotations.MockK
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.junit.Assert
import kotlin.coroutines.CoroutineContext

fun withRobot(lb: TagUseCaseRobot.() -> Unit): TagUseCaseRobot =
    TagUseCaseRobot().apply(lb)

class TagUseCaseRobot {

    @MockK
    lateinit var mockRepositoryTag: TagRepository

    private var dispatcher: CoroutineContext = Dispatchers.Unconfined + SupervisorJob()
    var tagUseCase: TagUseCase

    var success: Boolean? = null

    init {
        MockKAnnotations.init(this)
        tagUseCase = TagUseCase(mockRepositoryTag, dispatcher)
    }

    private val tagRepo = TagRepo(

        name = "",
        commit = Commit(sha = "", url = ""),
        zipballUrl = "",
        tarballUrl = "",
        nodeId = ""
    )

    private val listTag = listOf(tagRepo)

    infix fun launch(lb: ActionTagRobot.() -> Unit) =
        ActionTagRobot(this).apply(lb)

    fun andWhenGetRepositoryTagReturnsSuccess() {
        coEvery { mockRepositoryTag.getTagRepoOwner(any(), any()) } returns listTag
    }

    fun andWhenGetTagRepositoryRetunsError() {
        coEvery { mockRepositoryTag.getTagRepoOwner(any(), any()) }
    }

}

class ActionTagRobot(private val robot: TagUseCaseRobot) {

    infix fun check(lb: ResultTagRobot.() -> Unit) =
        ResultTagRobot(robot).apply(lb)

    fun getRepositoryTagOwner(owner: String, repo : String) {

        robot.tagUseCase.getTagRepoOwner(owner,repo) {success, _ ->

            robot.success = success
        }

    }
}

class ResultTagRobot(private val robot: TagUseCaseRobot) {

    fun thatGetRepositoryTagSuccess() {
        Assert.assertEquals(true, robot.success)
    }

    fun thatGetRepositoryTagError() {
        Assert.assertEquals(false, robot.success)
    }

}