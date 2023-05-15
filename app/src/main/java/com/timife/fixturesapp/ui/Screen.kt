package com.timife.fixturesapp.ui

sealed class Screen(val route: String) {
    object CompetitionsScreen : Screen("competitions_screen")
    object FixturesScreen : Screen("fixtures_screen")

    object FixtureInfoScreen : Screen("fixture_info")
}
