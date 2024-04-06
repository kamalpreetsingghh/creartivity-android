package com.cleverlycode.creartivity.data.repository

import com.cleverlycode.creartivity.data.models.Login
import com.cleverlycode.creartivity.data.models.SignUp
import com.cleverlycode.creartivity.data.remote.AuthService
import com.cleverlycode.creartivity.data.remote.LoginRequest
import com.cleverlycode.creartivity.data.remote.SignUpRequest
import javax.inject.Inject

class AuthRepository @Inject constructor(private val authService: AuthService) {
    suspend fun login(login: Login): APIResponseStatus {
        val loginRequest = LoginRequest(email = login.email, password = login.password)
        val response = authService.login(loginRequest)

        val apiResponseStatus =
            APIResponseStatus.getByCode(response.code()) ?: APIResponseStatus.SUCCESS

        if (response.isSuccessful) {
            response.body() ?: throw NullPointerException("User body is null")
        }

        return apiResponseStatus
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