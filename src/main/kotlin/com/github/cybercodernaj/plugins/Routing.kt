package com.github.cybercodernaj.plugins

import com.github.cybercodernaj.routing.homePage
import com.github.cybercodernaj.routing.slack.slackRoutes
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
    routing {
        homePage()
        slackRoutes()
    }
}
