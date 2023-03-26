package com.github.cybercodernaj.routing

import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Routing.homePage() {
    get("/") {
        call.respondText("Hello World!")
    }
}