package com.timife.fixturesapp.presentation.fixtures.state

import com.timife.fixturesapp.domain.model.Fixture

data class FixturesUiState(
    val fixtures: List<Fixture> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "No fixtures found",
    val matchDays: List<Int> = emptyList(),
    val matchDay: Int = 0,
    val competitionId: Int = 0,
    val selectedFilter: Int = 0,
    val isRefreshing: Boolean = false
)
