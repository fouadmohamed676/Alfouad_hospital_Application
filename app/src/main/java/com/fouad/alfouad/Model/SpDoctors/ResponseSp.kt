package com.fouad.alfouad.Model.SpDoctors

data class ResponseSp(
    val doctors: List<Doctor>,
    val response: MyResponse,
    val status: String
)