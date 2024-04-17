package com.fouad.alfouad

import com.fouad.alfouad.Model.forwards.Pation

data class ForwardResponse(
    val forward: List<Forward>,
    val pation: Pation,
    val status: String
)