package com.target.targetcasestudy.ui.deals

import androidx.lifecycle.*
import com.target.targetcasestudy.data.models.DealsListResponse
import com.target.targetcasestudy.data.network.Resource
import com.target.targetcasestudy.data.repository.DealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealListFragmentViewModel @Inject constructor(
    private val repository: DealsRepository
) : ViewModel(), LifecycleObserver {

    private val _productListResponse: MutableLiveData<Resource<DealsListResponse>> =
        MutableLiveData()
    val productListResponse: LiveData<Resource<DealsListResponse>>
        get() = _productListResponse

    init {
        getDealsList()
    }

    private fun getDealsList() = viewModelScope.launch {
        _productListResponse.value = Resource.Loading
        _productListResponse.value = repository.getDeals()
    }
}