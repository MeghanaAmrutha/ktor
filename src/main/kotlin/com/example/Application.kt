package com.example

import com.example.plugins.*
import com.example.routes.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args:Array<String>) {
    EngineMain.main(args)
}

fun Application.module() {
    configureSerialization()
    statusPage()
    configureRouting()
}
