package com.timife.fixturesapp.presentation.fixtures

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.usecases.GetFixturesUseCase
import com.timife.fixturesapp.presentation.fixtures.state.FixturesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixturesViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(FixturesUiState())
    val state: State<FixturesUiState> = _state

    init {
        savedStateHandle.get<Int>("competition")?.let { competition ->
            getFixtures(competition, 0)
        }
    }

    fun getFixtures(competitionId: Int, matchDay: Int) {
        viewModelScope.launch {
            getFixturesUseCase.invoke(competitionId).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.let { fixtures ->
                            val matchDays = fixtures.distinctBy { fixture ->
                                fixture.matchday
                            }.map { distinctFix ->
                                distinctFix.matchday
                            }.sortedDescending()
                            if (matchDay == 0) {
                                _state.value =
                                    state.value.copy(
                                        fixtures = fixtures,
                                        matchDays = matchDays,
                                        competitionId = competitionId,
                                        selectedFilter = matchDay
                                    )
                            } else {
                                val matchDayFixtures = fixtures.filter {
                                    it.matchday == matchDay
                                }
                                _state.value = state.value.copy(
                                    fixtures = matchDayFixtures,
                                    matchDay = matchDay,
                                    competitionId = competitionId,
                                    selectedFilter = matchDay
                                )
                            }
                        }
                    }
                    is Resource.Loading -> {
                        _state.value = state.value.copy(isLoading = resource.isLoading)
                    }
                    is Resource.Error -> {
                        _state.value =
                            state.value.copy(error = resource.message ?: "No fixtures available")
                    }
                }
            }
        }
    }
}