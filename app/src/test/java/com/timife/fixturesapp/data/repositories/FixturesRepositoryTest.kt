package com.timife.fixturesapp.data.repositories

import app.cash.turbine.test
import com.google.common.truth.Truth.assertThat
import com.timife.fixturesapp.data.local.FakeFixturesDao
import com.timife.fixturesapp.data.local.database.dao.FixturesDao
import com.timife.fixturesapp.data.local.model.*
import com.timife.fixturesapp.data.mappers.toFixture
import com.timife.fixturesapp.data.remote.FixturesApi
import com.timife.fixturesapp.domain.Resource
import io.mockk.coEvery
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.Before
import org.junit.Test

@OptIn(ExperimentalCoroutinesApi::class)
class FixturesRepositoryTest {

    private lateinit var repository: FixturesRepositoryImpl
    private lateinit var dao: FixturesDao
    private lateinit var api: FixturesApi

    @Before
    fun setUp() {
        val argument = 2001
        dao = FakeFixturesDao()
        api = mockk(relaxed = true) {
            coEvery {
                getMatches(argument)
            } returns mockk(relaxed = true)
        }
        repository = FixturesRepositoryImpl(
            dao, api
        )
    }

    @Test
    fun `fetch fixtures when database is not empty`() = runTest {
        /**
         * using turbine to test unit if subject under test is exposing a flow
         */
        dao.insertFixtures(localItems[0])
        repository.getFixtures(false, competitionId).test {
            val initialLoading = awaitItem()
            assertThat((initialLoading as Resource.Loading).isLoading).isTrue()
            val newItems = awaitItem()
            assertThat(newItems is Resource.Success).isTrue()
            assertThat(newItems.data).isEqualTo(localItems.map {
                it.toFixture()
            })
            val stopLoading = awaitItem()
            assertThat((stopLoading as Resource.Loading).isLoading).isFalse()
            awaitComplete()
        }

    }

    @Test
    fun `fetch fixtures on swipe to refresh or first entry`() = runTest {
        dao.insertFixtures(localItems[0])
        repository.getFixtures(true, competitionId).test {
            val initialLoading = awaitItem()
            assertThat((initialLoading as Resource.Loading).isLoading).isTrue()
            val newItems = awaitItem()
            assertThat(newItems is Resource.Success).isTrue()
            assertThat(newItems.data).isEqualTo(localItems.map {
                it.toFixture()
            })

            val item = awaitItem()
            assertThat(item is Resource.Success).isTrue()
            assertThat(newItems.data).isEqualTo(dao.getFixtures(competitionId).map {
                it.toFixture()
            })
            val stopLoading = awaitItem()
            assertThat((stopLoading as Resource.Loading).isLoading).isFalse()
            awaitComplete()
        }
    }

    companion object {
        const val competitionId = 2001

        val localItems = listOf(
            FixtureEntity(
                1,
                2001,
                "Premier League",
                HomeTeamEntity(1, "United", null, null, null),
                AwayTeamEntity(2, "Arsenal", null, null, null),
                ScoreEntity(
                    FullTimeEntity(2, 1),
                    HalfTimeEntity(2, 1),
                    RegularTimeEntity(2, 1),
                    ""
                ),
                "August", "", "Played", 3
            )
        )
    }
}