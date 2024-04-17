package com.fouad.alfouad.Model.specializations_hospital

data class SpecializationHospitalResponse(
    val hospitals: List<Hospital>,
    val response: Response,
    val status: String
)