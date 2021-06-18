package com.target.targetcasestudy.ui.dealitem

import androidx.lifecycle.*
import com.target.targetcasestudy.data.models.DealItemResponse
import com.target.targetcasestudy.data.network.Resource
import com.target.targetcasestudy.data.repository.DealsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DealItemFragmentViewModel @Inject constructor(
    private val repository: DealsRepository
) : ViewModel(), LifecycleObserver {

    private val _dealItem: MutableLiveData<Resource<DealItemResponse>> =
        MutableLiveData()
    val dealItem: LiveData<Resource<DealItemResponse>>
        get() = _dealItem


    fun getDealItem(id: Int) = viewModelScope.launch {
        _dealItem.value = Resource.Loading
        _dealItem.value = repository.getDealItem(id)
    }
}