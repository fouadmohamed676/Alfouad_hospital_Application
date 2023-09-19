package com.fouad.alfouad.Network

object Data {
//    http://127.0.0.1:8000/api/user/2
    private const val baseURL: String = "http://127.0.0.1:8000/api/"
    const val user: String = baseURL+"user/"
    const val show_user= "https://127.0.0.1:8000/api/user_auth"//baseURL+user
    const val show_hospital= baseURL+"hospitals"
    const val show_pations= baseURL+"pations"
//    const val show_hospitals= "https://tandtsa.com/tandt/show/adds_list.php"
//    const val show_hospitals= "http://127.0.0.1:8000/api/doctors/show"
    const val show_hospitals= "https://192.168.43.114/Project_Api/get_orders.php"
//    const val login= "https://192.168.43.114/apis/login.php"
    const val login= "https://192.168.43.114/apis/users.php"
//    const val show_hospitals= "http://127.0.0.1/hospital_api/hospital.php"
//    const val aucationList= show_url+"auctions_list.php"
}