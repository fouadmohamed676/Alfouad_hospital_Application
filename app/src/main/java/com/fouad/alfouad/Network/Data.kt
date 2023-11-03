package com.fouad.alfouad.Network

object Data {

//    private const val baseURL: String = "http://192.168.43.114/"  //http://192.168.43.114:8000/
    private const val baseURL: String = "http://192.168.137.1/"  //http://192.168.43.114:8000/
    const val Base_Url_Api="http://192.168.43.114:8000/api/" //http://192.168.43.114:8000/api/hospital/show
//    const val Base_Url_Api="http://192.168.43.114:8000/api/"
    private const val api= baseURL+"apis/"
    const val user = baseURL+"user/"
    const val show_hospital= Base_Url_Api+"hospital/show"
    const val show_hospital_retrofit= Base_Url_Api+"hospital/show"
    const val show_clink= Base_Url_Api+"clink/show"
    const val show_pharmacy= Base_Url_Api+"pharmacy/show"
    const val staff_pharmacy="http://192.168.43.114:8000/pharmacy/staff_pharmacy_/12"
    const val hospital_doctors="http://192.168.43.114:8000/hospital/hospitalDoctor/"//doctors working in this hospital
    const val login= Base_Url_Api+"user/"
    const val register= api+"register.php"

}