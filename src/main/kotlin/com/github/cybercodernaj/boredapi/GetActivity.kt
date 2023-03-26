package com.github.cybercodernaj.boredapi

import com.github.cybercodernaj.models.ActivityResponse
import io.ktor.client.call.*
import io.ktor.client.request.*

suspend fun getActivity(
    type: String = "recreational",
    participants: Int = 1
): ActivityResponse? {
    return ClientSupplier.get().use { client ->
        val response = client.get(ClientSupplier.BASE_URL + "/activity?type=$type&participants=$participants")
        if (response.status.value !in 200..299) {
            return@use null
        }

        response.body()
    }
}