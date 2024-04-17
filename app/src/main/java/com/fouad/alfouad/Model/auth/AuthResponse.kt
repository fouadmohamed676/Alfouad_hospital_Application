package com.fouad.alfouad.Model.auth

data class AuthResponse(
    val status: String,
    val response: List<Response>)