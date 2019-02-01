package com.fourall.dxlabs.koinproject.models

data class Product(
    val id: Int = 0,
    val uuid: String? = null,
    val thumb: String? = null,
    val title: String? = null,
    val subtitle: String? = null,
    val quantity: String? = null,
    val price: String? = null,
    val timestamp: String? = null,
    val barCode: String? = null,
    val storeId: Int = 0
)