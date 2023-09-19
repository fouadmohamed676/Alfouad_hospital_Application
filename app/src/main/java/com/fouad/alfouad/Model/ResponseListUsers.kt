package com.fouad.alfouad.Model

import com.google.gson.annotations.SerializedName

data class ResponseListUsers(
    @SerializedName("page")
    var page: Int,
)