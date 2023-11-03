package com.fouad.alfouad.Model

import com.fouad.alfouad.HospitalPojoO
import com.google.gson.annotations.SerializedName

class ResponseResult {
    @SerializedName("response" ) var mHospitalList: ArrayList<HospitalPojoO> = ArrayList()
    @SerializedName("status"   ) var mStatus   : String?             = null
}
data class Hospitals (

    @SerializedName("id"         ) var id        : Int?    = null,
    @SerializedName("name"       ) var name      : String? = null,
    @SerializedName("created_at" ) var createdAt : String? = null,
    @SerializedName("updated_at" ) var updatedAt : String? = null

)


data class LocalHospital (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

)
