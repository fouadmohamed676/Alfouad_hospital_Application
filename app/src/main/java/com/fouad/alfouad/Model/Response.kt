package com.fouad.alfouad.Model

import com.fouad.alfouad.Model.doctor_hospitals.Doctor
import com.fouad.alfouad.Time

data class Response(
    val created_at: Any,
    val doctors: List<Doctor>,
    val genders: Genders,
    val id: Int,
    val name: String,
    val price_interview: String,
    val specialization: Specialization,
    val times: List<Time>,
    val updated_at: Any
)