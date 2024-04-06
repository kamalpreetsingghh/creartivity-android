package com.cleverlycode.creartivity.data.models

data class User(
    val _id: String,
    val clerkId: String,
    val firstName: String,
    val lastName: String,
    val email: String,
    val username: String,
    val planId: Int,
    val creditBalance: Int
)