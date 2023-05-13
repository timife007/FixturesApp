package com.timife.fixturesapp.data.local.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.timife.fixturesapp.data.local.model.CompetitionEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface CompetitionsDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCompetition(competition: List<CompetitionEntity>)

    @Query("DELETE FROM competition_entity")
    suspend fun clearAllCompetition()

    @Query("SELECT * FROM competition_entity")
    suspend fun getAllCompetitions(): List<CompetitionEntity>

}