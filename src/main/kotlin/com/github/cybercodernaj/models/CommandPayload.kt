package com.github.cybercodernaj.models

import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class CommandPayload(
    val token: String,
    val command: String,
    val text: String,
    @SerialName("response_url")
    val responseUrl: String,
    @SerialName("user_id")
    val userId: String,
    @SerialName("api_app_id")
    val apiAppId: String,
) {
    companion object {
        suspend fun parseParameters(call: ApplicationCall) = with(call.receiveParameters()) {
            CommandPayload(
                token = get("token") ?: "",
                command = get("command") ?: "",
                text = get("text") ?: "",
                responseUrl = get("response_url") ?: "",
                userId = get("user_id") ?: "",
                apiAppId = get("api_app_id") ?: ""
            )
        }
    }
}