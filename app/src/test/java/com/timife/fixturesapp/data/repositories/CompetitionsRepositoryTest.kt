package com.timife.fixturesapp.data.repositories

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.timife.fixturesapp.data.local.FakeCompetitionsDao
import com.timife.fixturesapp.data.local.database.dao.CompetitionsDao
import com.timife.fixturesapp.data.local.model.CompetitionEntity
import com.timife.fixturesapp.data.mappers.toCompetition
import com.timife.fixturesapp.data.remote.FixturesApi
import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.repositories.CompetitionsRepository
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class CompetitionsRepositoryTest {
    private lateinit var repository: CompetitionsRepository
    private lateinit var dao: CompetitionsDao
    private lateinit var api: FixturesApi

    @Before
    fun setUp() {
        dao = FakeCompetitionsDao()
        api = mockk(relaxed = true) {
            coEvery {
                getCompetitions()
            } returns mockk(relaxed = true)
        }
        repository = CompetitionsRepositoryImpl(
            dao, api
        )
    }

    @Test
    fun getCompetitions() = runTest {
        /**
         * using turbine to test unit if subject under test is exposing a flow
         */
        dao.insertCompetition(localItems)
        repository.getCompetitions().test {
            val loading = awaitItem()
            assertThat((loading as Resource.Loading).isLoading).isTrue()
            val newItems = awaitItem()
            assertThat(newItems is Resource.Success).isTrue()
            assertThat(newItems.data).isEqualTo(localItems.map {
                it.toCompetition()
            })
            val stopLoading = awaitItem()
            assertThat((stopLoading as Resource.Loading).isLoading).isFalse()
            awaitComplete()
        }
    }

    companion object {
        val localItems = listOf(
            CompetitionEntity(
                1, "English Premier League", "https:epl.svg", "EPL"
            )
        )
    }
}
