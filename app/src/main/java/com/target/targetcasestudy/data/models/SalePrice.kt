package com.target.targetcasestudy.data.models

import androidx.annotation.Keep

@Keep
data class SalePrice(
    val amount_in_cents: Int,
    val currency_symbol: String,
    val display_string: String
)