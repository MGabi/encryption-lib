package com.mgabbi.encryption.core.main.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.map
import androidx.lifecycle.viewModelScope
import com.mgabbi.encryption.data.models.MockItem
import com.mgabbi.encryption.shared.base.BaseViewModel
import com.mgabbi.encryption.shared.base.successOr
import com.mgabbi.encryption.shared.event.BaseEvent
import com.mgabbi.encryption.shared.utils.SingleLiveEvent
import kotlinx.coroutines.Dispatchers

class ListViewModel(
    getMockListUseCase: GetMockListUseCase
) : BaseViewModel() {

    private val _cmd = SingleLiveEvent<Command>()
    val cmd: LiveData<Command>
        get() = _cmd

    val mockList: LiveData<List<MockItem>> = getMockListUseCase(viewModelScope, Unit, Dispatchers.IO).map {
        it.successOr(listOf())
    }

    sealed class Command : BaseEvent
}
