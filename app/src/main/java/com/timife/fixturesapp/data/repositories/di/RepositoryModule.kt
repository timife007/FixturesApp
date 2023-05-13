package com.timife.fixturesapp.data.repositories.di

import com.timife.fixturesapp.data.repositories.CompetitionsRepositoryImpl
import com.timife.fixturesapp.data.repositories.FixturesRepositoryImpl
import com.timife.fixturesapp.domain.repositories.CompetitionsRepository
import com.timife.fixturesapp.domain.repositories.FixturesRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    @Singleton
    abstract fun bindCompetitionRepository(
        competitionRepository: CompetitionsRepositoryImpl,
    ): CompetitionsRepository

    @Binds
    @Singleton
    abstract fun bindFixturesRepository(
        fixturesRepository: FixturesRepositoryImpl,
    ): FixturesRepository

}