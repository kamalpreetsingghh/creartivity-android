package com.cleverlycode.creartivity.data.remote

import com.cleverlycode.creartivity.data.models.User
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

data class LoginRequest(val email: String, val password: String)

data class SignUpRequest(val email: String, val password: String, val username: String)

interface AuthService {
    @POST("signin")
    suspend fun login(@Body request: LoginRequest): Response<User>

    @POST("signup")
    suspend fun signUp(@Body request: SignUpRequest): Response<User>
}