package com.cleverlycode.creartivity.data.remote

import com.cleverlycode.creartivity.data.models.ImageId
import retrofit2.Response
import retrofit2.http.GET

interface ImageService {
    @GET("ids")
    suspend fun getImages(): Response<List<ImageId>>
}