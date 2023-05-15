package com.timife.fixturesapp.domain.usecases

import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Fixture
import com.timife.fixturesapp.domain.repositories.FixturesRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetFixturesUseCase @Inject constructor(
    private val fixturesRepository: FixturesRepository,
) {
    operator fun invoke(fetchFromRemote:Boolean,competitionId: Int): Flow<Resource<List<Fixture>>> {
        return fixturesRepository.getFixtures(fetchFromRemote,competitionId)
    }
}