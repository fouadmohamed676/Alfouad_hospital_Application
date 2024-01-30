package com.fouad.alfouad.Model.hospital

import com.fouad.alfouad.Response
import java.io.Serializable

data class HospitalBojo(
    val response: List<Response>,
    val status: String
) :Serializable


data class Doctor(
    val id: Int,
    val name: String
):Serializable
data class Local(
    val id: Int,
    val name: String
)
data class Specialization(
    val id: Int,
    val name: String
)
