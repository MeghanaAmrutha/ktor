package com.example.repository

import com.example.httpClient.getClient
import com.example.interfaces.ProductInterface
import com.example.models.Api
import com.example.models.Product
import com.google.gson.Gson
import io.ktor.client.request.*
import io.ktor.client.statement.*

open class ProductRepository: ProductInterface{

    override suspend fun getApiData(): Api {
        val url = getClient().get("https://dummyjson.com/products")
        return  Gson().fromJson(url.bodyAsText(), Api::class.java)
    }

    override suspend fun getFilteredData(discountPercentage: Double?, rating: Double?): Product? {
        val data = getApiData()
        val filteredData = data.products.filter { product ->
            product.discountPercentage == discountPercentage && product.rating == rating
        }.singleOrNull()

        return filteredData
    }

}