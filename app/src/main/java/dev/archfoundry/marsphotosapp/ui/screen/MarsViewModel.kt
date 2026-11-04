package dev.archfoundry.marsphotosapp.ui.screen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import dev.archfoundry.marsphotosapp.MarsPhotosApplication
import dev.archfoundry.marsphotosapp.data.MarsPhotosRepository
import dev.archfoundry.marsphotosapp.data.NetworkMarsPhotosRepository
import dev.archfoundry.marsphotosapp.network.MarsPhoto
import kotlinx.coroutines.launch
import okhttp3.Call
import java.io.IOException


class MarsViewModel(private val marsPhotosRepository: MarsPhotosRepository) : ViewModel()  {
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

    companion object{
        val Factory : ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as MarsPhotosApplication)
                val marsPhotosRepository = application.container.marsPhotosRepository
                MarsViewModel(marsPhotosRepository)
            }
        }
    }
}

sealed interface MarsUistate {
    data class Success(val photos:String) : MarsUistate
    object Error : MarsUistate
    object Loading: MarsUistate
}