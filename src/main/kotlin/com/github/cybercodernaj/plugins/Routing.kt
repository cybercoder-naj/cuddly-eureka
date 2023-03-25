package com.github.cybercodernaj.plugins

import com.github.cybercodernaj.routing.greet
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        greet()
    }
}
