package com.timife.fixturesapp.data.local.database.dao

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.timife.fixturesapp.data.local.database.FixturesDatabase
import com.timife.fixturesapp.data.local.model.*
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.junit.Assert.*

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
    fun insertFixtures() {
    }

    @Test
    fun clearAllFixtures() {
    }

    @Test
    fun getFixtures() {
    }

    companion object{
        const val competitionId = 2001

        val localItems = listOf(
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