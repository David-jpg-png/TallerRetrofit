package dev.archfoundry.marsphotosapp.data

import dev.archfoundry.marsphotosapp.network.MarsApi
import dev.archfoundry.marsphotosapp.network.MarsPhoto

interface MarsPhotosRepository {
    suspend fun getMarsPhotos(): List<MarsPhoto>
}

class NetworkMarsPhotosRepository : MarsPhotosRepository{

    override suspend fun getMarsPhotos(): List<MarsPhoto> {
        return MarsApi.retrofitService.getPhotos()
    }
}