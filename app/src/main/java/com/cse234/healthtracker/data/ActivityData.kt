package com.cse234.healthtracker.data

import java.util.Date

data class ActivityData(
    val userId: String,
    val activityType: String,
    val startTime: Long,
    val endTime: Long,
    val duration: Long,
    val distance: Double,
    val date : Date
){
    constructor() : this("", "", 0L, 0L, 0L, 0.0 , Date())
}
