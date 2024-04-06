package com.cleverlycode.creartivity.data.models

data class Image(
    val _id: String,
    val title: String,
    val transformationType: String? = null,
    val publicId: String? = null,
    val secureURL: String,
    val width: Int? = null,
    val height: Int? = null,
    val config: Config? = null,
    val transformationURL: String? = null,
    val aspectRatio: String? = null,
    val color: String? = null,
    val prompt: String? = null,
    val author: Author,
    val createdAt: String,
    val updatedAt: String
)

data class Config(
    val restore: Boolean? = null,
    val fillBackground: Boolean? = null,
    val removeBackground: Boolean? = null
)

data class Author(
    val _id: String,
    val clerkId: String,
    val firstName: String,
    val lastName: String
)