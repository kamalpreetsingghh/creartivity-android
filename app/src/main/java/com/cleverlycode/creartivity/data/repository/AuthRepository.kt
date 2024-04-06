package com.cleverlycode.creartivity.data.repository

import com.cleverlycode.creartivity.data.models.User
import com.cleverlycode.creartivity.data.remote.AuthService
import com.cleverlycode.creartivity.data.remote.LoginRequest
import com.cleverlycode.creartivity.utils.Result
import java.io.IOException
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {
    suspend fun login(
        email: String,
        password: String
    ): Result<User> {
        return Result.build {
            val loginRequest = LoginRequest(email, password)
            val response = authService.login(loginRequest)
            if (response.isSuccessful) {
                response.body() ?: throw NullPointerException("User body is null")
            } else {
                throw IOException("Error occurred during login: ${response.message()}")
            }
        }
    }
}