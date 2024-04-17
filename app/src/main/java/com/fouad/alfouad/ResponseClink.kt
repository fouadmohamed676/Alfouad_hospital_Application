package com.fouad.alfouad

import com.fouad.alfouad.Model.clink.Local

data class ResponseClink(
    val id: Int,
    val local: Local,
    val name: String,
    val phone: String,
    val status: String
)