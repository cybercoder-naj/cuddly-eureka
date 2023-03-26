package com.github.cybercodernaj.routing.slack

import io.ktor.server.routing.*

fun Route.slackRoutes() {
    route("/slack") {
        greet()
        boredCommand()
    }
}