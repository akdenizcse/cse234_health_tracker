package com.cse234.healthtracker.data

import java.util.Date

data class UserInfo(
    val email : String,
    val gender :  String,
    val height : Double,
    val weight : Double,
    val birthDate : Date
){
    constructor() : this("","",0.0,0.0, Date())
}
