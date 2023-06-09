package com.github.cybercodernaj.routing.slack

import com.slack.api.Slack
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.greet() {
    get("/greet") {
        val token = System.getenv("SLACK_TOKEN")
        val slack = Slack.getInstance()
        val response = slack.methods(token).chatPostMessage {
            it.channel("#first-bot")
                .text("Hello :wave:")
        }
        call.respondText("Response is: $response")
    }
}