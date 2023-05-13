package com.timife.fixturesapp.data.remote

import com.timife.fixturesapp.data.remote.dtos.competitionsdto.CompetitionsDto
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.FixturesDto
import retrofit2.http.GET
import retrofit2.http.Path

interface FixturesApi {

    @GET("competitions/{id}/matches/")
    suspend fun getMatches(
        @Path("id") competitionId: Int
    ): FixturesDto

    @GET("competitions")
    suspend fun getCompetitions(): CompetitionsDto
}