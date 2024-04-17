package com.fouad.alfouad.Model.forwards

data class Pation(
    val email: String,
    val id: Int,
    val name: String,
    val phone: String,
    val local: Local,
    val doctor: Doctor,
    val nationality: Nationality,
    val sicks: List<Sick>,
    val blood: Blood,
)