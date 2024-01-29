package com.example.repositoryTesting

import com.example.plugins.NotFoundException
import com.example.repository.ProductRepository
import junit.framework.TestCase.assertEquals
import kotlinx.coroutines.runBlocking
import org.junit.Test
import kotlin.test.assertFailsWith

class RepositoryTesting {
    private val productRepo = ProductRepository()

    @Test
    fun testRepoProducts(): Unit = runBlocking {
        productRepo.getApiData().apply {
            assertEquals(549,this.products[0].price)
        }
    }

    @Test
    fun testProduct(): Unit = runBlocking {
        productRepo.getFilteredData(15.46, 4.09).apply {
            assertEquals("Samsung Universe 9", this?.title)
        }
    }
}