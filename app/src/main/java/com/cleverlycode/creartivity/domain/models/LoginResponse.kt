package com.cleverlycode.creartivity.domain.models

import com.cleverlycode.creartivity.data.models.User
import com.cleverlycode.creartivity.data.repository.APIResponseStatus

data class LoginResponse(
    val apiResponseStatus: APIResponseStatus,
    val user: User?
)