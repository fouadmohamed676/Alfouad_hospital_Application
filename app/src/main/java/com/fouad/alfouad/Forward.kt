package com.fouad.alfouad

import com.fouad.alfouad.Model.forwards.Doctor
import com.fouad.alfouad.Model.forwards.ForwordFrom
import com.fouad.alfouad.Model.forwards.ForwordTo
import com.fouad.alfouad.Model.forwards.Hospital

data class Forward(
    val date: String,
    val doctor: Doctor,
    val file_number: Int,
    val forword_from: ForwordFrom,
    val forword_to: ForwordTo,
    val hospital: Hospital,
    val id: Int
)