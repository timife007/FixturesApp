package com.timife.fixturesapp.domain.usecases

import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Competition
import com.timife.fixturesapp.domain.repositories.CompetitionsRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetCompetitionsUseCase @Inject constructor(
    private val competitionsRepository: CompetitionsRepository,
) {
    operator fun invoke(): Flow<Resource<List<Competition>>> {
        return competitionsRepository.getCompetitions()
    }
}