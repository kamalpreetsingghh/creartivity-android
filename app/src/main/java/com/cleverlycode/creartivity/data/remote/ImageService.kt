package com.cleverlycode.creartivity.data.remote

import com.cleverlycode.creartivity.data.models.ImageId
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Query

interface ImageService {
    @GET("ids")
    suspend fun getImages(@Query("searchQuery") searchQuery: String): Response<List<ImageId>>
}