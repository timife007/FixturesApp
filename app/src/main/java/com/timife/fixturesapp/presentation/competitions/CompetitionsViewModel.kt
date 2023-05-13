package com.timife.fixturesapp.presentation.competitions

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.timife.fixturesapp.domain.Resource
import com.timife.fixturesapp.domain.usecases.GetCompetitionsUseCase
import com.timife.fixturesapp.presentation.competitions.state.CompetitionUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CompetitionsViewModel @Inject constructor(
    private val getCompetitionsUseCase: GetCompetitionsUseCase,
) : ViewModel() {

    private val _state = mutableStateOf(CompetitionUiState())
    val state : State<CompetitionUiState> = _state

    init {
        getCompetitions()
    }

    private fun getCompetitions() {
        viewModelScope.launch {
            getCompetitionsUseCase.invoke().collect {resource ->
                when (resource) {
                    is Resource.Success -> {
//                        _state.value =
////                            CompetitionUiState(competitions = it.data ?: emptyList())
//                            state.value.copy(competitions = it.data ?: emptyList(), isLoading = false)
                        resource.data?.let {
                            _state.value = state.value.copy(competitions = it )
                        }
                    }
                    is Resource.Loading -> {
                        _state.value =
//                            CompetitionUiState(isLoading = true)
                            state.value.copy(isLoading = resource.isLoading)
                    }
                    is Resource.Error -> {
//                        _state.value = CompetitionUiState(error = it.message ?: "Unexpected error occurred")
//                            _state.value = state.value.copy(error = resource.message ?: "No data found", isLoading = false)
                    }
                }
            }
        }

    }
}