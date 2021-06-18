package com.target.targetcasestudy.data.models

data class DealItemResponse(
    val aisle: String,
    val description: String,
    val id: Int,
    val image_url: String,
    val title: String,
    val regular_price: RegularPrice,
    val sale_price: SalePrice?,
)