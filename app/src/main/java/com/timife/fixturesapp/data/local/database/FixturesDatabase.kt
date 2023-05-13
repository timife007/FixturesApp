package com.timife.fixturesapp.data.local.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.timife.fixturesapp.data.local.database.dao.CompetitionsDao
import com.timife.fixturesapp.data.local.database.dao.FixturesDao
import com.timife.fixturesapp.data.local.model.CompetitionEntity
import com.timife.fixturesapp.data.local.model.FixtureEntity

@Database(
    entities = [FixtureEntity::class, CompetitionEntity::class],
    version = 1,
    exportSchema = false
)
abstract class FixturesDatabase : RoomDatabase() {
    abstract val fixturesDao: FixturesDao
    abstract val competitionsDao: CompetitionsDao
}