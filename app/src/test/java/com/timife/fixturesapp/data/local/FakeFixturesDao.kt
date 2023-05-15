package com.timife.fixturesapp.data.local

import com.timife.fixturesapp.data.local.database.dao.FixturesDao
import com.timife.fixturesapp.data.local.model.FixtureEntity

class FakeFixturesDao : FixturesDao {

    private var database = emptyList<FixtureEntity>()
    override suspend fun insertFixtures(fixtures: FixtureEntity) {
        database = database + fixtures
    }

    override suspend fun clearAllFixtures() {
        database = emptyList()
    }

    override suspend fun getFixtures(competitionId: Int): List<FixtureEntity> {
        return database.filter {
            it.competitionId == competitionId
        }
    }


}