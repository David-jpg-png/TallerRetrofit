package dev.archfoundry.marsphotosapp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dev.archfoundry.marsphotosapp.data.NetworkMarsPhotosRepository
import dev.archfoundry.marsphotosapp.network.MarsApi
import dev.archfoundry.marsphotosapp.network.MarsPhoto
import kotlinx.coroutines.launch
import java.io.IOException


class MarsViewModel : ViewModel()  {
    var marsUiState: MarsUistate by mutableStateOf(MarsUistate.Loading)
        private set

    init {
        getMarsPhotos()
    }
    fun getMarsPhotos(){
        viewModelScope.launch {
            try {
                val marsPhotosRepository = NetworkMarsPhotosRepository()
                val result : List<MarsPhoto> = marsPhotosRepository.getMarsPhotos()
                marsUiState = MarsUistate.Success("${result.size} fotos desde la api.")
            }catch (e: IOException){
                marsUiState = MarsUistate.Error
            }
        }
    }
}

sealed interface MarsUistate {
    data class Success(val photos:String) : MarsUistate
    object Error : MarsUistate
    object Loading: MarsUistate
}