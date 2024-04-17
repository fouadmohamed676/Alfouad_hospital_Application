package com.fouad.alfouad.Model.create_pation

data class CreatePationResponse(
    val blood: List<Blood>,
    val locals: List<Local>,
    val nationality: List<Nationality>,
    val status: String
)