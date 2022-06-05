package com.example.finalproject.database

    class Product(
       product_id: Int,
       product_name: String,
       product_price: Int,
       product_description: String,
       product_score:Int
    ) {

        val product_id: Int = product_id
        val product_name: String = product_name
        val product_price: Int = product_price
        val product_description: String = product_description
       val  product_score : Int = product_score

    }

    fun Product.toEntity() = ProductEntity(
        product_id,
        product_name,
        product_price,
        product_description,
        product_score
    )

