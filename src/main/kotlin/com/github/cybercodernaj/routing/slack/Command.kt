package com.github.cybercodernaj.routing.slack

import com.github.cybercodernaj.boredapi.getActivity
import com.github.cybercodernaj.models.CommandPayload
import com.slack.api.Slack
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.boredCommand() {
    post("/command") {
        val payload = CommandPayload.parseParameters(call)
        val commandParams = payload.text.split(" ")
        val activity = if (commandParams.size == 2) {
            val type = commandParams[0]
            val participants = commandParams[1].toInt()

            getActivity(type, participants)
        } else if (commandParams.size == 1) {
            val param = commandParams[0].toIntOrNull()

            if (param == null)
                getActivity(type = commandParams[0])
            else
                getActivity(participants = param)
        } else null

        activity ?: run {
            call.respond(HttpStatusCode.BadRequest, "Poorly formed request")
            return@post
        }

        val token = System.getenv("SLACK_TOKEN")
        val slack = Slack.getInstance()
        slack.methods(token).chatPostMessage {
            it.channel("#first-bot")
                .text("Hmmm, you're bored. Go ${activity.activity.lowercase()}.")
        }

        call.respond(HttpStatusCode.OK)
    }
}