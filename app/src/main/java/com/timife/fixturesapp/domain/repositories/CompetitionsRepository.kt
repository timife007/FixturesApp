package com.timife.fixturesapp.domain.repositories

import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Competition
import kotlinx.coroutines.flow.Flow

interface CompetitionsRepository {
    fun getCompetitions(): Flow<Resource<List<Competition>>>
}