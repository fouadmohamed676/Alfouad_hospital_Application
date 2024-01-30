package com.fouad.alfouad.Model.pation

data class Pation(
    val doctors: List<Doctor>,
    val hospitals: List<Hospital>,
    val locals: List<Local>,
    val nationality: List<Nationality>,
    val status: String
)