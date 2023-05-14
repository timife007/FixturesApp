package com.timife.fixturesapp.data.repositories

import com.timife.fixturesapp.data.local.database.dao.CompetitionsDao
import com.timife.fixturesapp.data.mappers.toCompetition
import com.timife.fixturesapp.data.mappers.toCompetitionEntity
import com.timife.fixturesapp.data.remote.FixturesApi
import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Competition
import com.timife.fixturesapp.domain.repositories.CompetitionsRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CompetitionsRepositoryImpl @Inject constructor(
    private val dao: CompetitionsDao,
    private val api: FixturesApi,
) : CompetitionsRepository {
    override fun getCompetitions(): Flow<Resource<List<Competition>>> {
        return flow {
            emit(Resource.Loading(true))
            val localCompetition = dao.getAllCompetitions()
            emit(Resource.Success(localCompetition.map {
                    it.toCompetition()
                }))

            //Should only load data from db if Db is not empty and remote fetch is false.
            val isDbEmpty = localCompetition.isEmpty()
            val shouldLoadFromDb = !isDbEmpty
            if (shouldLoadFromDb) {
                emit(Resource.Loading(false))
                return@flow
            }

            //fetch competitions from api
            val remoteCompetitions = try {
                api.getCompetitions().competitions
            } catch (e: IOException) {
                emit(Resource.Error(e.message))
                null
            } catch (e: HttpException) {
                emit(Resource.Error(e.message))
                null
            }

            //When new data is available, clear cache and insert new
            remoteCompetitions?.let { item ->
                dao.clearAllCompetition()
                dao.insertCompetition(
                    item.map {
                        it.toCompetitionEntity()
                    }
                )
                emit(
                    Resource.Success(
                        data = dao.getAllCompetitions().map {
                            it.toCompetition()
                        }
                    ))
                emit(
                    Resource.Loading(
                        false
                    )
                )
            }
        }
    }
}