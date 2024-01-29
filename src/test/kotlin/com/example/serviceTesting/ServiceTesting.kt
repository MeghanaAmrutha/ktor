package com.example.serviceTesting

import com.example.models.Api
import com.example.models.Product
import com.example.plugins.NotFoundException
import com.example.service.ProductService
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith

class ServiceTesting {
    private val productService = ProductService()

    @Test
    fun testServiceProducts(): Unit = runBlocking {
        productService.getApiResult().apply {
            assertEquals(products,this.products,"success!")
        }
    }

    @Test
    fun testServiceProduct(): Unit = runBlocking {
        productService.getFilteredResult(15.46, 4.09).apply {
            assertEquals("Samsung's new variant which goes beyond Galaxy to the Universe", this?.description, "Product found..")
        }
    }

}