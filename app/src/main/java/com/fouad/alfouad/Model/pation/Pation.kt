package com.fouad.alfouad.Model.pation


data class Pation(
    val email: String,
    val id: Int,
    val local: Local,
    val name: String,
    val nationality: Nationality,
    val phone: String,
    val sicks: List<Sick>,
    val blood: Blood,
)
