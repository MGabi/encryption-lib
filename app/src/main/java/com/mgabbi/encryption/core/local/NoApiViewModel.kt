package com.mgabbi.encryption.core.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.mgabbi.encryption.shared.base.BaseViewModel
import com.mgabbi.encryption.shared.utils.LiveEvent

class NoApiViewModel : BaseViewModel() {

    // Properties

    private val _cmd = LiveEvent<Command>()
    val cmd: LiveData<Command> = _cmd

    val message = MutableLiveData<String>()

    val encrypted = message.map { "" }

    val decrypted = encrypted.map { "" }

    // Actions

    // Command

    sealed class Command
}
