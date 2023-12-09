package com.example.ijo_in.data.remote.plants.dto

import com.squareup.moshi.JsonClass
import com.taru.data.remote.plants.dto.inner.PlantsSearchEntryDto
import com.taru.data.remote.plants.dto.inner.PlantsSearchMetaDto

class PlantsSearchDto {

    @JsonClass(generateAdapter = true)
    data class PlantsSearchDto(
//    val id: String,
        val data: List<PlantsSearchEntryDto>,
        val meta: PlantsSearchMetaDto
    ) {
    }
}