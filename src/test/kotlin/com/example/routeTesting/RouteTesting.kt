package com.example.routeTesting

import com.example.models.Api
import com.example.models.Product
import com.example.models.Request
import com.example.models.Response
import com.example.plugins.NotFoundException
import com.example.routes.configureRouting
import com.example.utils.ApiEndPoints
import com.example.utils.InfoMessage
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.server.testing.*
import junit.framework.TestCase.assertEquals
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlin.test.*;


class RouteTesting {

    @Test
    fun testProducts() = testApplication {

        val response = client.get(ApiEndPoints.API_PRODUCTS)
        if (response.status == HttpStatusCode.OK) {
            val body = response.bodyAsText()
            if (body.isNotBlank()) {
                val productResponse = Json.decodeFromString<Api>(body)
                assertEquals(30, productResponse.limit)
            } else {
                throw NotFoundException(Response(InfoMessage.DATA_NOT_FOUND, false))
            }
        }
    }

    @Test
    fun testProduct() = testApplication {

        val request = Request(15.46, 4.09)
        val serializer = Json.encodeToString(request)
        val result = client.get(ApiEndPoints.PARAM) {
            contentType(ContentType.Application.Json)
            setBody(serializer)
        }
        if (request.equals(result)){
            val productResponse = Json.decodeFromString<Product>(result.bodyAsText())
            assertEquals("Samsung", productResponse.brand)
            assertEquals(HttpStatusCode.OK, result.status)
        }
    }
}
