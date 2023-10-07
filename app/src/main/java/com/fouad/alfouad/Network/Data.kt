package com.fouad.alfouad.Network

object Data {

    private const val baseURL: String = "http://192.168.137.1/"
    const val url="http://192.168.137.1:8000/api/"
    const val api= baseURL+"apis/"
    const val user = baseURL+"user/"
    const val show_hospital= url+"hospital/show"
    const val show_clink= url+"clink/show"
    const val show_pharmacy= url+"pharmacy/show"
    const val hospital_doctors="http://192.168.137.1:8000/hospital/hospitalDoctor/2"//doctors working in this hospital
    const val login= api+"login.php"
    const val register= api+"register.php"

}