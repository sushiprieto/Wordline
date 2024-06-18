package com.carlosprieto.wordline.presentation.details

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.carlosprieto.wordline.common.Constants
import com.carlosprieto.wordline.common.Resource
import com.carlosprieto.wordline.domain.usecase.GetStadiumListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import javax.inject.Inject

@HiltViewModel
class StadiumDetailsViewModel @Inject constructor(
    private val getStadiumListUseCase: GetStadiumListUseCase,
    savedStateHandle: SavedStateHandle
) : ViewModel() {

    private val _state = mutableStateOf(StadiumDetailsState())
    val state: State<StadiumDetailsState> = _state

    init {
        savedStateHandle.get<String>(Constants.PARAM_STADIUM_ID)?.let {
            getStadiumDetails()
        }
    }

    private fun getStadiumDetails() {
        getStadiumListUseCase().onEach { result ->
            when (result) {
                is Resource.Success -> {
//                    _state.value = StadiumDetailsState(data = result.data)
                }
                is Resource.Error -> {
                    _state.value = StadiumDetailsState(
                        errorMessage = result.message ?: "An unexpected error occured"
                    )
                }
                is Resource.Loading -> {
                    _state.value = StadiumDetailsState(isLoading = true)
                }
            }
        }.launchIn(viewModelScope)
    }
}
