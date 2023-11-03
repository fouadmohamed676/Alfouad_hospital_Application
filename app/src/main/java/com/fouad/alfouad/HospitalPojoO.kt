package com.fouad.alfouad

import com.fouad.alfouad.Model.Hospitals
import com.fouad.alfouad.Model.LocalHospital
import com.google.gson.annotations.SerializedName

data class HospitalPojoO(@SerializedName("id"             ) var id            : Int?           = null,
                         @SerializedName("dis"            ) var dis           : String?        = null,
                         @SerializedName("address"        ) var address       : String?        = null,
                         @SerializedName("phone"          ) var phone         : String?        = null,
                         @SerializedName("status"         ) var status        : Int?           = null,
                         @SerializedName("local_id"       ) var localId       : Int?           = null,
                         @SerializedName("is_deleted"     ) var isDeleted     : Int?           = null,
                         @SerializedName("local_hospital" ) var localHospital : LocalHospital? = LocalHospital(),
                         @SerializedName("hospitals"      ) var hospitals     : Hospitals?     = Hospitals()
)
