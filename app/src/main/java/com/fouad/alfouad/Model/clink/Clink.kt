package com.fouad.alfouad.Model.clink

import com.fouad.alfouad.ResponseClink

data class Clink(
    val response: List<ResponseClink>,
    val status: String
)

data class Local(
    val id: Int,
    val name: String
)