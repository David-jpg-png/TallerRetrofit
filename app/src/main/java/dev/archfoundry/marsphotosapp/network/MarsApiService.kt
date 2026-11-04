package dev.archfoundry.marsphotosapp.network

import android.util.JsonToken
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import retrofit2.Retrofit
import retrofit2.converter.kotlinx.serialization.asConverterFactory
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com/"

private val retrofit = Retrofit.Builder()
    .addConverterFactory(Json.asConverterFactory("aplication/jason".toMediaType()))
    .baseUrl(BASE_URL)
    .build()

interface MarsApiService{
    @GET(value = "photos")
    suspend fun getPhotos() : List<MarsPhoto>
}