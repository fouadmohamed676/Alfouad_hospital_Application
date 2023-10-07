package com.fouad.alfouad.Network

object Data {

    private const val baseURL: String = "http://192.168.137.1/apis/"
    const val user = baseURL+"user/"
    const val show_hospital= "http://192.168.137.1:8000/api/hospital/show"
    const val show_clink= "http://192.168.137.1:8000/api/clink/show"
    const val show_pharmacy= "http://192.168.137.1:8000/api/pharmacy/show"

    const val login= baseURL+"login.php"
    const val register=baseURL+"register.php"

}