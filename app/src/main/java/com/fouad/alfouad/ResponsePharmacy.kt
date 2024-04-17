package com.fouad.alfouad

import com.fouad.alfouad.Model.pharmacy.Day
import com.fouad.alfouad.Model.pharmacy.Local


data class ResponsePharmacy(

    val id: Int,
    val name: String,
    val phone: String,
    val title: String,
    val local: Local,
    val days: List<Day>,
    val staffs: List<Staff>,
    val status: Int,

)
