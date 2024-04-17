package com.fouad.alfouad.Model.pharmacy

import com.fouad.alfouad.ResponsePharmacy

data class PharmacyResponse(
    val response: List<ResponsePharmacy>,
    val status: String
)