package com.example.service

import com.example.utils.InfoMessage
import com.example.models.Api
import com.example.models.Product
import com.example.models.Response
import com.example.plugins.NotFoundException
import com.example.repository.ProductRepository

class ProductService{

    private val productRepo = ProductRepository()

    suspend fun getApiResult(): Api{
        try {
            return productRepo.getApiData()

        } catch (e: Exception) {
            throw NotFoundException(Response(InfoMessage.DATA_NOT_FOUND, false))
        }
    }

    suspend fun getFilteredResult(discountPercentage: Double?, rating: Double?): Product? {
        try {
            return productRepo.getFilteredData(discountPercentage, rating)

        } catch (e: Exception) {
            throw NotFoundException(Response(InfoMessage.PARAM_NOT_FOUND, false))
        }

    }

}