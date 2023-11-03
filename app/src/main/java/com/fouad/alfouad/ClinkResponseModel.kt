package com.fouad.alfouad

import com.google.gson.annotations.SerializedName

class ClinkResponseModel {

    @SerializedName("status"   ) var status   : String?             = null
    @SerializedName("response" ) var cLinkResponse : ArrayList<ClinkResponse> = ArrayList()
}
data class Local (

    @SerializedName("id"   ) var id   : Int?    = null,
    @SerializedName("name" ) var name : String? = null

)
data class ClinkResponse (

    @SerializedName("id"       ) var id      : Int?    = null,
    @SerializedName("name"     ) var name    : String? = null,
    @SerializedName("local_id" ) var localId : Int?    = null,
    @SerializedName("phone"    ) var phone   : String? = null,
    @SerializedName("status"   ) var status  : Int?    = null,
    @SerializedName("local"    ) var local   : Local?  = Local()

)