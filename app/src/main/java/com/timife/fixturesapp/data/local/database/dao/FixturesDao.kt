package com.timife.fixturesapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timife.fixturesapp.data.local.model.CompetitionEntity
import com.timife.fixturesapp.data.local.model.FixtureEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FixturesDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertFixtures(fixtures: FixtureEntity)

    @Query("DELETE FROM fixture_entity")
    suspend fun clearAllFixtures()

    @Query("SELECT * FROM fixture_entity WHERE :competitionId == competitionId")
    suspend fun getFixtures(competitionId: Int): List<FixtureEntity>
}