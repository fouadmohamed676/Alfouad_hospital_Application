package com.fouad.alfouad

import org.json.JSONObject

data class Hospital(
    val id:String,
    val dis:String,
    val address:String,
    val phone:String,
    val status:String,
    val local_id:String,
    val local_hospital:JSONObject,
    val hospitals:JSONObject,
    )
