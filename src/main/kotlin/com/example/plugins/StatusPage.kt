package com.example.plugins

import com.example.models.Response
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.plugins.statuspages.*
import io.ktor.server.response.*

fun Application.statusPage() {
    install(StatusPages) {
        exception<Throwable> { call, cause ->
            when(cause) {
                is NotFoundException -> call.respond(HttpStatusCode.NotFound, cause.msg)
            }
            call.respondText(text = "Success", status = HttpStatusCode.InternalServerError)
        }
    }
}

class NotFoundException(val msg: Response): RuntimeException()
