package com.mgabbi.encryption.core.local

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.map
import com.mgabbi.encryption.lib.crypto.Encryption
import com.mgabbi.encryption.shared.base.BaseViewModel
import com.mgabbi.encryption.shared.utils.LiveEvent

class NoApiViewModel : BaseViewModel() {

    // Properties

    private val _cmd = LiveEvent<Command>()
    val cmd: LiveData<Command> = _cmd

    val message = MutableLiveData<String>()

    private val encrypted = message.map { Encryption.encode(it) }
    val encryptedString = encrypted.map { it.toString(Charsets.UTF_8) }

    val decrypted = encrypted.map { Encryption.decode(it) }

    // Actions

    // Command

    sealed class Command
}
