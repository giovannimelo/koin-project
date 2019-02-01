package com.fourall.dxlabs.koinproject.repositories

import android.content.Context
import android.util.Log
import com.fourall.dxlabs.koinproject.models.Product
import com.google.gson.Gson

class ProductRepositoryImpl : ProductRepository {

    override fun getProducts(context: Context): List<Product> {
        return try {
            val stringReader = context.assets.open("raw/products.json").bufferedReader().use { it.readText() }
            Gson().fromJson(stringReader, Array<Product>::class.java).toList()
        } catch (e: Exception){
            Log.d("errorAsset", e.message)
            arrayListOf()
        }
    }
}