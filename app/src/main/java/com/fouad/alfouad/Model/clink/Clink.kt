package com.fouad.alfouad.Model.clink

data class Clink(
    val response: List<Response>,
    val status: String
)
data class Response(
    val id: Int,
    val local: Local,
    val name: String,
    val phone: String
)
data class Local(
    val id: Int,
    val name: String
)