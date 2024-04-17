package com.fouad.alfouad.Model.doctor

import com.fouad.alfouad.DoctorHospital
import com.fouad.alfouad.Time

data class DoctorData(
    val response: Response,
    val status: String
)
data class Response(
    val doctors: List<DoctorHospital>,
    val genders: Genders,
    val id: Int,
    val name: String,
    val price_interview: String,
    val specialization: Specialization,
    val times: List<Time>
)

data class Specialization(
    val id: Int,
    val name: String
)

data class Genders(
    val id: Int,
    val name: String
)