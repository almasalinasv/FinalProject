package com.example.finalproject.database

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyCoroutines(private val ProductDao: ProductDao) {
    suspend fun save(product: Product) = withContext(Dispatchers.IO){
        ProductDao.save((product.toEntity()))
    }

    suspend fun delete(product: Product) = withContext(Dispatchers.IO){
        ProductDao.delete(product.toEntity())
    }

    suspend fun getProducts(): LiveData<List<Product>> = withContext(Dispatchers.IO){
        return@withContext MutableLiveData(ProductDao.getProductsFromDatabase().map{ eachProductEntity ->
            eachProductEntity.toProduct()})
    }
}