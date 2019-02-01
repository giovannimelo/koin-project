package com.fourall.dxlabs.koinproject.viewmodels

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.content.Context
import android.os.Handler
import com.fourall.dxlabs.koinproject.models.Product
import com.fourall.dxlabs.koinproject.repositories.ProductRepository

class ProductViewModel(private val repo: ProductRepository) : ViewModel() {

    val productsLiveData: MutableLiveData<List<Product>> = MutableLiveData()

    fun getProducts(context : Context) {
        Handler().post { productsLiveData.value = repo.getProducts(context) }
    }
}