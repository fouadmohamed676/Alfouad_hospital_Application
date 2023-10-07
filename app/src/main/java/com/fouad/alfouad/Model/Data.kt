package com.fouad.alfouad.Model

import com.fouad.alfouad.Clinck
import com.fouad.alfouad.Locals

data class Data(
    val barth_date: String,
    val clinck: Clinck,
    val clinic_id: Int,
    val email: String,
    val gender_id: String,
    val genders: Genders,
    val hospital: List<HospitalX>,
    val hospital_id: Int,
    val id: Int,
    val local_id: Int,
    val locals: Locals,
    val name: String,
    val national: National,
    val nationality_id: Int,
    val phone: String,
    val specialization_id: String,
    val specilization: Specilization,
    val status: Int,
    val times: List<Time>,
    val title: String
)