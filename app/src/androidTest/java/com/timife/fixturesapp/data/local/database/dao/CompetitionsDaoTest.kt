package com.timife.fixturesapp.data.local.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.google.common.truth.Truth.assertThat
import com.timife.fixturesapp.data.local.database.FixturesDatabase
import com.timife.fixturesapp.data.local.model.CompetitionEntity
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class CompetitionsDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var database: FixturesDatabase
    private lateinit var dao: CompetitionsDao

    @Before
    fun setup() {
        database = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            FixturesDatabase::class.java
        ).allowMainThreadQueries().build()
        dao = database.competitionsDao
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun insertCompetition() = runTest {
        dao.insertCompetition(competitions)
        val getCompetitions = dao.getAllCompetitions()
        assertThat(getCompetitions).isEqualTo(competitions)
    }

    @Test
    fun clearAllCompetition() = runTest {
        dao.insertCompetition(competitions)
        val storedData = dao.getAllCompetitions()
        assertThat(storedData).isNotEmpty()
        dao.clearAllCompetition()
        assertThat(dao.getAllCompetitions()).isEmpty()
    }

    @Test
    fun getAllCompetitions() = runTest {
        dao.insertCompetition(competitions)
        val storedData = dao.getAllCompetitions()
        assertThat(storedData).isNotEmpty()
    }

    companion object {
        val competitions = listOf(
            CompetitionEntity(2021, "Premier League", "https:epl.svg", "EPL"),
            CompetitionEntity(2022, "Laliga", "https:laliga.svg", "LLG")
        )
    }
}