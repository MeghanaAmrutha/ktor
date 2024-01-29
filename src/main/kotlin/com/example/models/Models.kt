package com.example.models

import kotlinx.serialization.Serializable

@Serializable
data class Api(val products: List<Product>, val total: Int, val skip: Int, val limit: Int)

@Serializable
data class Product(val id: Int,
    val title: String,
    val description: String,
    val price: Int,
    val discountPercentage: Double,
    val rating: Double,
    val stock: Int,
    val brand: String,
    val category: String,
    val thumbnail: String,
    val images: List<String>
    )

@Serializable
data class Response(val message: String, val success: Boolean)

@Serializable
data class Request(val discountPercentage: Double, val rating: Double)
