package com.timife.fixturesapp.data.local.di

import android.app.Application
import androidx.room.Room
import com.timife.fixturesapp.data.local.database.FixturesDatabase
import com.timife.fixturesapp.data.local.database.dao.CompetitionsDao
import com.timife.fixturesapp.data.local.database.dao.FixturesDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun provideFixturesDb(app: Application): FixturesDatabase {
        return Room.databaseBuilder(
            app,
            FixturesDatabase::class.java,
            "fixtures.db"
        ).build()
    }

    @Provides
    @Singleton
    fun provideFixturesDao(
        fixturesDatabase: FixturesDatabase
    ): FixturesDao {
        return fixturesDatabase.fixturesDao
    }

    @Provides
    @Singleton
    fun provideCompetitionsDao(
        fixturesDatabase: FixturesDatabase
    ): CompetitionsDao {
        return fixturesDatabase.competitionsDao
    }
}