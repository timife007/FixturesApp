package com.timife.fixturesapp.presentation.competitions.state

import com.timife.fixturesapp.domain.model.Competition

data class CompetitionUiState(
    val competitions: List<Competition> = emptyList(),
    val isLoading: Boolean = false,
    val error: String = "",
    val searchText:String = "",
    val isSearchActive:Boolean = false
)