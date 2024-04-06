package com.cleverlycode.creartivity.data.repository

import com.cleverlycode.creartivity.data.remote.AuthService
import com.cleverlycode.creartivity.data.remote.LoginRequest
import com.cleverlycode.creartivity.data.remote.SignUpRequest
import com.cleverlycode.creartivity.domain.models.Login
import com.cleverlycode.creartivity.domain.models.LoginResponse
import com.cleverlycode.creartivity.domain.models.SignUp
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {
    suspend fun login(login: Login): LoginResponse {
        val loginRequest = LoginRequest(email = login.email, password = login.password)
        val response = authService.login(loginRequest)

        val apiResponseStatus =
            APIResponseStatus.getByCode(response.code()) ?: APIResponseStatus.SUCCESS

        val user = if (response.isSuccessful) {
            response.body() ?: throw NullPointerException("User body is null")
        } else {
            null
        }

        return LoginResponse(apiResponseStatus = apiResponseStatus, user = user)
    }

    suspend fun signup(signUp: SignUp): APIResponseStatus {
        val signUpRequest = SignUpRequest(
            firstName = signUp.firstName,
            lastName = signUp.lastName,
            userName = signUp.userName,
            email = signUp.email,
            password = signUp.password
        )

        val response = authService.signUp(signUpRequest)

        return APIResponseStatus.getByCode(response.code()) ?: APIResponseStatus.SUCCESS
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