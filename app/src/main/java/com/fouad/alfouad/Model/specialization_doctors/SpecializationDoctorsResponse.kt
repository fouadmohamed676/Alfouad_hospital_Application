package com.fouad.alfouad.Model.specialization_doctors

import com.fouad.alfouad.ResponseDoctorsSp

data class SpecializationDoctorsResponse(
    val doctors: List<Doctor>,
    val response: ResponseDoctorsSp,
    val status: String
)