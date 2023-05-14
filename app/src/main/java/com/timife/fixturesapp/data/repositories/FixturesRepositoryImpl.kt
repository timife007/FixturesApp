package com.timife.fixturesapp.data.repositories

import com.timife.fixturesapp.data.local.database.dao.FixturesDao
import com.timife.fixturesapp.data.mappers.toFixture
import com.timife.fixturesapp.data.mappers.toFixtureEntity
import com.timife.fixturesapp.data.remote.FixturesApi
import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Fixture
import com.timife.fixturesapp.domain.repositories.FixturesRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FixturesRepositoryImpl @Inject constructor(
    private val dao: FixturesDao,
    private val api: FixturesApi,
) : FixturesRepository {
    override fun getFixtures(competitionId: Int): Flow<Resource<List<Fixture>>> {

        return flow {
            emit(Resource.Loading(true))
            val localFixtures = dao.getFixtures(competitionId)
            emit(Resource.Success(localFixtures.map {
                it.toFixture()
            }))

            //Should only load data from db if Db is not empty and remote fetch is false.
            val isDbEmpty = localFixtures.isEmpty()
            val shouldLoadFromDb = !isDbEmpty
            if (shouldLoadFromDb) {
                emit(Resource.Loading(false))
                return@flow
            }

            //fetch fixtures from api
            val remoteFixtures = try {
                api.getMatches(competitionId).matches
            } catch (e: IOException) {
                emit(Resource.Error(e.message))
                null
            } catch (e: HttpException) {
                emit(Resource.Error(e.message))
                null
            }

            //When new data is available, clear cache and insert new
            remoteFixtures?.let { item ->
                item.forEach {
                    if (it.homeTeam.name != null) {
                        dao.insertFixtures(
                            it.toFixtureEntity()
                        )
                    }
                }
//                dao.insertFixtures(
//                    item.map {
//                        it.toFixtureEntity()
//                    }
//                )
                    emit(
                        Resource.Success(
                            data = dao.getFixtures(competitionId).map { fixtureEntity ->
                                fixtureEntity.toFixture()
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