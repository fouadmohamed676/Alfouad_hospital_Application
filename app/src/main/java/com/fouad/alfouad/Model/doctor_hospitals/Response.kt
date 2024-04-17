package com.fouad.alfouad.Model.doctor_hospitals

import com.fouad.alfouad.Doctor

data class Response(
    val address: String,
    val dis: String,
    val doctor: List<Doctor>,
    val clink: List<Clink>,
    val enter_price: String,
    val id: Int,
    val local: Local,
    val local_id: Int,
    val phone: String,
    val times: List<Time>,
    val specialization: Specialization,
    val status: Int
)