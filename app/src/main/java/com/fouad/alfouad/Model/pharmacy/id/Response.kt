package com.fouad.alfouad.Model.pharmacy.id

data class Response(
    val days: List<Day>,
    val id: Int,
    val local: Local,
    val name: String,
    val phone: String,
    val staffs: List<Staff>,
    val status: Int,
    val title: String
)