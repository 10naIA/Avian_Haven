package no.uio.ifi.in2000.avianhaven.ui.library

import no.uio.ifi.in2000.avianhaven.data.BirdRepository
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.avianhaven.data.Entity
import no.uio.ifi.in2000.avianhaven.data.SoundRepository


data class BirdUIState(
    val currentEntityList: List<Entity> = listOf(),
    )

class BirdLibraryViewModel: ViewModel() {
    private val birdRepository: BirdRepository = BirdRepository

    private val _birdUiState = MutableStateFlow(BirdUIState())
    val birdUiState: StateFlow<BirdUIState> = _birdUiState.asStateFlow()

    init {
        updateState()
    }

    private fun updateState() {
        viewModelScope.launch {
            if(!birdRepository.getStatus()) {
                birdRepository.storeDeserializedData()
            }
            _birdUiState.update {
                BirdUIState(
                    currentEntityList = birdRepository.getStoredData(),
                )
            }
        }
    }
}