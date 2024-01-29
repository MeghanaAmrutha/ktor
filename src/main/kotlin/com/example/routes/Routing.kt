package com.example.routes

import com.example.utils.InfoMessage
import com.example.models.Response
import com.example.service.ProductService
import com.example.utils.ApiEndPoints
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Application.configureRouting() {

    val productService = ProductService()

    routing {

            get(ApiEndPoints.API_PRODUCTS) {
                val result = productService.getApiResult()
                call.respond(HttpStatusCode.OK,result)
            }

            get(ApiEndPoints.PARAM) {
                val discountPercentage = call.parameters["discountPercentage"]?.toDoubleOrNull()
                val rating = call.parameters["rating"]?.toDoubleOrNull()

                val filteredProduct = productService.getFilteredResult(discountPercentage, rating)
                if (filteredProduct != null) {
                    call.respond(HttpStatusCode.OK, filteredProduct)
                } else {
                    call.respond(HttpStatusCode.NotFound, Response(InfoMessage.PARAM_NOT_FOUND, false))
                }
            }
        }
}
