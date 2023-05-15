package com.timife.fixturesapp.data.local.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.timife.fixturesapp.data.local.database.FixturesDatabase
import com.timife.fixturesapp.data.local.model.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest

import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class FixturesDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: FixturesDatabase
    private lateinit var dao: FixturesDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FixturesDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.fixturesDao
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertFixtures() = runTest {
        dao.insertFixtures(fixtures[0])
        val getFixtures = dao.getFixtures(competitionId)
        assertThat(getFixtures).isEqualTo(fixtures)
    }

    @Test
    fun clearAllFixtures() = runTest {
        dao.insertFixtures(fixtures[0])
        val getFixtures = dao.getFixtures(competitionId)
        assertThat(getFixtures).isEqualTo(fixtures)
        dao.clearAllFixtures()
        assertThat(dao.getFixtures(competitionId)).isEmpty()
    }

    @Test
    fun getFixtures() = runTest {
        dao.insertFixtures(fixtures[0])
        val getFixtures = dao.getFixtures(competitionId)
        assertThat(getFixtures).isEqualTo(fixtures)
    }

    companion object {
        const val competitionId = 2001

        val fixtures = listOf(
            FixtureEntity(
                1,
                2001,
                "Premier League",
                HomeTeamEntity(1, "United", null, null, null),
                AwayTeamEntity(2, "Arsenal", null, null, null),
                ScoreEntity(
                    FullTimeEntity(1, 1),
                    HalfTimeEntity(1, 1),
                    RegularTimeEntity(1, 1),
                    ""
                ),
                "August", "", "Played", 3
            )
        )
    }
}