package com.timife.fixturesapp.data.local

import com.timife.fixturesapp.data.local.database.dao.CompetitionsDao
import com.timife.fixturesapp.data.local.model.CompetitionEntity

class FakeCompetitionsDao : CompetitionsDao {
    private var database = emptyList<CompetitionEntity>()
    override suspend fun insertCompetition(competition: List<CompetitionEntity>) {
        database = database + competition
    }

    override suspend fun clearAllCompetition() {
        database = emptyList()
    }

    override suspend fun getAllCompetitions(): List<CompetitionEntity> {
        return database
    }
}