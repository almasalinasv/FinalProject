package com.example.finalproject.database

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = TABLE_PRODUCTS)
data class ProductEntity(
    @ColumnInfo(name = "product_id")@PrimaryKey(autoGenerate = true) val uuid: Int,
    @ColumnInfo(name = "product_name") val name: String,
    @ColumnInfo(name = "product_price") val price: Int,
    @ColumnInfo(name = "product_description") val description: String,
    @ColumnInfo(name = "product_score") val score: Int,
    )
fun ProductEntity.toProduct() = Product(
    uuid,
    name,
    price,
    description,
    score
)
