package com.fourall.dxlabs.koinproject.repositories

import android.content.Context
import com.fourall.dxlabs.koinproject.models.Product

interface ProductRepository {

    fun getProducts(context: Context): List<Product>
}