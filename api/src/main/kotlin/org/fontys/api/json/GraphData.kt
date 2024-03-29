package org.fontys.api.json

import kotlinx.serialization.Serializable

@Serializable
data class GraphData(
    val x: Long,
    val fetalBlood: Int,
    val fetalBloodPressure: Int,
    val uterineContractions: Int,
    val fetalHeartRate: Int
)
