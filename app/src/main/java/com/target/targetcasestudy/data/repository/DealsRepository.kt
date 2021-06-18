package com.target.targetcasestudy.data.repository

import com.target.targetcasestudy.data.network.SafeApiCall
import com.target.targetcasestudy.data.network.TargetApi
import javax.inject.Inject

class DealsRepository @Inject constructor(
    private val api: TargetApi
) : SafeApiCall {

    suspend fun getDeals() = safeApiCall { api.getDeals() }
    suspend fun getDealItem(id: Int) = safeApiCall { api.getDealItem(id) }
}