package com.timife.fixturesapp.presentation.fixtures

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.model.Competition
import com.timife.fixturesapp.domain.usecases.GetFixturesUseCase
import com.timife.fixturesapp.presentation.fixtures.state.FixturesUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FixturesViewModel @Inject constructor(
    private val getFixturesUseCase: GetFixturesUseCase,
    savedStateHandle: SavedStateHandle,
) : ViewModel() {
    private val _state = mutableStateOf(FixturesUiState())
    val state : State<FixturesUiState> = _state

    init {
        savedStateHandle.get<Int>("competition")?.let { competition ->
            getFixtures(competition)
        }
    }

    private fun getFixtures(competitionId: Int) {
        viewModelScope.launch {
            getFixturesUseCase.invoke(competitionId).collect { resource ->
                when (resource) {
                    is Resource.Success -> {
                        resource.data?.let {
                            _state.value = state.value.copy(fixtures = it)
                        }
                    }
                    is Resource.Loading -> {
                        _state.value = state.value.copy(isLoading = resource.isLoading)
                    }
                    is Resource.Error -> {
                        _state.value = state.value.copy(error = resource.message ?: "No fixtures available")
                    }
                }
            }
        }
    }
}