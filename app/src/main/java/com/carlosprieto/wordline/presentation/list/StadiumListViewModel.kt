package com.carlosprieto.wordline.presentation.list

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosprieto.wordline.common.Resource
import com.carlosprieto.wordline.data.remote.response.StadiumListResponse
import com.carlosprieto.wordline.domain.usecase.GetStadiumListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StadiumListViewModel @Inject constructor(
    private val getStadiumListUseCase: GetStadiumListUseCase
) : ViewModel() {

    private val _state = mutableStateOf(StadiumListState())
    val state: State<StadiumListState> = _state

    private val _searchWidgetState: MutableState<SearchWidgetState> =
        mutableStateOf(value = SearchWidgetState.CLOSED)
    val searchWidgetState: State<SearchWidgetState> = _searchWidgetState

    private val _searchTextState: MutableState<String> =
        mutableStateOf(value = "")
    val searchTextState: State<String> = _searchTextState

    fun updateSearchWidgetState(newValue: SearchWidgetState) {
        _searchWidgetState.value = newValue
    }

    fun updateSearchTextState(newValue: String) {
        _searchTextState.value = newValue
    }

    init {
        getStadiums()
    }

    private fun getStadiums() {
        getStadiumListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
                    _state.value = StadiumListState(data = result.data ?: StadiumListResponse(emptyList()))
                }
                is Resource.Error -> {
                    _state.value = StadiumListState(
                        errorMessage = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = StadiumListState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
