package com.cleverlycode.creartivity.data.repository

import com.cleverlycode.creartivity.data.remote.AuthService
import com.cleverlycode.creartivity.data.remote.LoginRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {
    suspend fun login(
        email: String,
        password: String
    ): APIResponseStatus {
        val loginRequest = LoginRequest(email, password)
        val response = authService.login(loginRequest)

        val apiResponseStatus =
            APIResponseStatus.getByCode(response.code()) ?: APIResponseStatus.SUCCESS

        if (response.isSuccessful) {
            response.body() ?: throw NullPointerException("User body is null")
        }

        return apiResponseStatus
    }
}

enum class APIResponseStatus(val code: Int) {
    SUCCESS(200),
    BAD_REQUEST(400),
    UNAUTHORIZED(401),
    NOT_FOUND(404),
    INTERNAL_SERVER_ERROR(500);

    companion object {
        fun getByCode(code: Int): APIResponseStatus? {
            return entries.find { it.code == code }
        }
    }
}