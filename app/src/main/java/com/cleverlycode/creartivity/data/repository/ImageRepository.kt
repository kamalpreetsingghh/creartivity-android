package com.cleverlycode.creartivity.data.repository

import com.cleverlycode.creartivity.data.models.ImageId
import com.cleverlycode.creartivity.data.remote.ImageService
import javax.inject.Inject

class ImageRepository @Inject constructor(private val imageService: ImageService) {
    suspend fun getImages(searchQuery: String = ""): List<ImageId> {
        var images = emptyList<ImageId>()
        val response = imageService.getImages(searchQuery = searchQuery)

        if (response.isSuccessful && response.body() != null) {
            images = response.body() ?: emptyList()
        }

        return images
    }
}