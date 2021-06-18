package com.target.targetcasestudy.data.models

import androidx.annotation.Keep

@Keep
data class DealsListResponse(
    val products: List<Product>
)