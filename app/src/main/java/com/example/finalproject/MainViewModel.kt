package com.example.finalproject

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.finalproject.database.DatabaseManager
import com.example.finalproject.database.MyCoroutines
import com.example.finalproject.database.Product
import kotlinx.coroutines.launch

class MainViewModel:ViewModel() {
    fun saveProduct(product: Product){
        viewModelScope.launch {
            val productDao = DatabaseManager.instance.database.ProductDao()
            MyCoroutines(productDao).save(product)
        }
    }

    fun deleteUser(product: Product) {
        viewModelScope.launch {
            viewModelScope.launch {
                val productDao = DatabaseManager.instance.database.ProductDao()
                MyCoroutines(productDao).delete(product)
            }
        }
    }
    val savedProducts = MutableLiveData<List<Product>>()
    fun getProducts(){
        viewModelScope.launch {
            val productDao = DatabaseManager.instance.database.ProductDao()
            savedProducts.value = MyCoroutines(productDao).getProducts().value
        }
    }
}