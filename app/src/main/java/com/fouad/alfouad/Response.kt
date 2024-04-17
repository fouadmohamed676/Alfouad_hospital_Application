package com.fouad.alfouad

import com.fouad.alfouad.Model.hospital.Doctor
import com.fouad.alfouad.Model.hospital.Local
import com.fouad.alfouad.Model.hospital.Specialization

data class Response (
    val address: String,
    val dis: String,
    val doctor: ArrayList<Doctor>,
    val enter_price: String,
    val id: Int,
    val local: Local,
    val local_id: Int,
    val phone: String,
    val status: String,
    val specialization: Specialization
)
