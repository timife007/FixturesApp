package com.timife.fixturesapp.presentation.fixtures.state

import com.timife.fixturesapp.domain.model.Fixture

data class FixturesUiState(
    val header: String = "",
    val fixtures: List<Fixture> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "No fixtures found",
)
