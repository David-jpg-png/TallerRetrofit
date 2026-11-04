package dev.archfoundry.marsphotosapp.data

import dev.archfoundry.marsphotosapp.network.MarsApiService
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory

interface AppContainer {
    val marsPhotosRepository : MarsPhotosRepository
}

class DefaultAppContainer : AppContainer{
    private  val baseUrl = "https://android-kotlin-fun-mars-server.appspot.com/"

    private val retrofit = Retrofit.Builder()
        .addConverterFactory(Json.asConverterFactory("aplication/jason".toMediaType()))
        .baseUrl(baseUrl)
        .build()

    val retrofitService : MarsApiService by lazy {
        retrofit.create(MarsApiService::class.java)
    }

    override val marsPhotosRepository: MarsPhotosRepository by lazy {
        NetworkMarsPhotosRepository(retrofitService)
    }

}