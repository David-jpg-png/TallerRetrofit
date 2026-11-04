package dev.archfoundry.marsphotosapp.data

import dev.archfoundry.marsphotosapp.network.MarsApiService
import dev.archfoundry.marsphotosapp.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository(private val marsApiService: MarsApiService) : MarsPhotosRepository{

    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return marsApiService.getPhotos()
    }
}