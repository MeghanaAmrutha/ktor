package com.example.interfaces

import com.example.models.Api
import com.example.models.Product

interface ProductInterface {

   suspend fun getApiData(): Api
   suspend fun getFilteredData(discountPercentage: Double?, rating: Double?): Product?
}