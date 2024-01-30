package com.fouad.alfouad.Network

object Data {

    private const val baseURL: String = "http://192.168.174.55/"  //http://192.168.43.114:8000/
    const val Base_Url_Api="http://192.168.174.55:8000/api/" //http://192.168.43.114:8000/api/hospital/show
    private const val api= baseURL+"api/"
    const val hospitalBojo= api+"hospital"
    const val port= baseURL+"8000/"
    const val show_hospital= api+"hospital/"
    const val show_pharmacy= api+"pharmacy"
    const val hospital_doctors="http://192.168.1.228:8000/hospital/show_pharmacy/"//doctors working in this hospital
    const val login= baseURL+"apis/login.php"
    const val interviews= api+"api/"
    const val register= api+"register.php"

}