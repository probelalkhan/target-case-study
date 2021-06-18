package com.target.targetcasestudy.data.models

import androidx.annotation.Keep

@Keep
data class Product(
    val aisle: String,
    val description: String,
    val id: Int,
    val image_url: String,
    val regular_price: RegularPrice,
    val sale_price: SalePrice?,
    val title: String
)