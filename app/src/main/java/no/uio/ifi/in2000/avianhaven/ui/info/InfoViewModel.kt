package no.uio.ifi.in2000.avianhaven.ui.info

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import no.uio.ifi.in2000.avianhaven.data.BirdRepository
import no.uio.ifi.in2000.avianhaven.data.Entity

data class InfoUIState(
    val currentEntity: Entity? = null,
    val currentName: String? = null,
)

class InfoViewModel: ViewModel() {
    private val birdRepository: BirdRepository = BirdRepository

    private val _infoUiState = MutableStateFlow(InfoUIState())
    val infoUiState: StateFlow<InfoUIState> = _infoUiState.asStateFlow()

    private var chosenName: String = ""

    fun updateChosenBird(name: String) {
        chosenName = name
    }

    init {
        viewModelScope.launch {
            updateState()
        }
    }

    private fun updateState() {
        viewModelScope.launch {
            _infoUiState.update {
                InfoUIState(
                    currentName = chosenName,
                    currentEntity = birdRepository.getChosenBird(chosenName)
                )
            }
        }
    }
}