package com.timife.fixturesapp.data.mappers

import com.timife.fixturesapp.data.local.model.*
import com.timife.fixturesapp.data.remote.dtos.competitionsdto.CompetitionDto
import com.timife.fixturesapp.data.remote.dtos.fixturesdto.*
import com.timife.fixturesapp.domain.model.Competition
import com.timife.fixturesapp.domain.model.Fixture
import com.timife.fixturesapp.domain.model.Scores

fun CompetitionDto.toCompetitionEntity(): CompetitionEntity {
    return CompetitionEntity(
        id = id, name = name, emblem = emblem, code = code
    )
}

fun CompetitionEntity.toCompetition(): Competition {
    return Competition(
        id = id, name = name, emblem = emblem, code = code
    )
}

fun HomeTeam.toHomeTeamEntity(): HomeTeamEntity {
    return HomeTeamEntity(
        id = id,
        crest = crest,
        name = name,
        shortName = shortName,
        tla = tla
    )
}

fun HomeTeamEntity.toHomeTeam(): HomeTeam {
    return HomeTeam(
        id = id,
        crest = crest,
        name = name,
        shortName = shortName,
        tla = tla
    )
}

fun AwayTeam.toAwayTeamEntity(): AwayTeamEntity {
    return AwayTeamEntity(
        id = id,
        crest = crest,
        name = name,
        shortName = shortName,
        tla = tla
    )
}

fun AwayTeamEntity.toAwayTeam(): AwayTeam {
    return AwayTeam(
        id = id,
        crest = crest,
        name = name,
        shortName = shortName,
        tla = tla
    )
}

fun FullTime.toFullTimeEntity(): FullTimeEntity {
    return FullTimeEntity(
        home = home,
        away = away
    )
}

fun HalfTime.toHalfTimeEntity(): HalfTimeEntity {
    return HalfTimeEntity(
        home = home,
        away = away
    )
}

fun RegularTime.toRegularTimeEntity(): RegularTimeEntity {
    return RegularTimeEntity(
        home = home ?: 0,
        away = away ?: 0
    )
}

fun Score.toScoreEntity(): ScoreEntity {
    return ScoreEntity(
        fullTime = fullTime.toFullTimeEntity(),
        halfTime = halfTime.toHalfTimeEntity(),
        regularTime = regularTime?.toRegularTimeEntity() ?: RegularTimeEntity(0, 0),
        duration = duration
    )
}

fun FullTimeEntity.toFullTime(): FullTime {
    return FullTime(
        away = away,
        home = home
    )
}

fun HalfTimeEntity.toHalfTime(): HalfTime {
    return HalfTime(
        away = away,
        home = home
    )
}

fun RegularTimeEntity.toRegularTime(): RegularTime {
    return RegularTime(
        away = away,
        home = home
    )
}

fun ScoreEntity.toScores(): Scores {
    return Scores(
        fullTime = fullTime?.toFullTime() ?: FullTime(0, 0),
        halfTime = halfTime?.toHalfTime() ?: HalfTime(0, 0),
        duration = duration,
        regularTime = regularTime?.toRegularTime() ?: RegularTime(0, 0)
    )
}

fun Match.toFixtureEntity(): FixtureEntity {
    return FixtureEntity(
        id = id,
        competitionId = competition.id,
        competitionName = competition.name,
        homeTeam = homeTeam.toHomeTeamEntity(),
        awayTeam = awayTeam.toAwayTeamEntity(),
        score = score.toScoreEntity(),
        matchDate = convertUtcToLocalDate(utcDate),
        matchTime = convertUtcToLocalTime(utcDate),
        status = status
    )
}

fun FixtureEntity.toFixture(): Fixture {
    return Fixture(
        id = id,
        competitionId = competitionId,
        competitionName = competitionName,
        homeTeam = homeTeam.toHomeTeam(),
        awayTeam = awayTeam.toAwayTeam(),
        score = score.toScores(),
        matchDate = matchDate,
        matchTime = matchTime,
        status = status
    )
}