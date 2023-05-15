package com.timife.fixturesapp.domain.repositories

import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Fixture
import kotlinx.coroutines.flow.Flow

interface FixturesRepository {
    fun getFixtures(fetchFromRemote: Boolean, competitionId: Int): Flow<Resource<List<Fixture>>>
}