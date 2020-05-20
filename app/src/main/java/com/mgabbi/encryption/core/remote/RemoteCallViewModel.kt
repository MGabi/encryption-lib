package com.mgabbi.encryption.core.remote

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.mgabbi.encryption.data.models.SimpleRequest
import com.mgabbi.encryption.data.models.SimpleResponse
import com.mgabbi.encryption.data.repo.EncryptedRepo
import com.mgabbi.encryption.shared.base.BaseViewModel
import com.mgabbi.encryption.shared.utils.LiveEvent
import org.koin.core.KoinComponent
import org.koin.core.inject

class RemoteCallViewModel : BaseViewModel(), KoinComponent {

    private val repo by inject<EncryptedRepo>()

    // Properties

    private val _cmd = LiveEvent<Command>()
    val cmd: LiveData<Command> = _cmd

    val message = MutableLiveData<String>()

    val receivedMessage = MutableLiveData(SimpleResponse("No text sent yet"))

    fun sendMessage() {
        performApiCall {
            val msg = message.value ?: "empty"
            val response = repo.sendMessage(SimpleRequest(msg))

            receivedMessage.value = response
        }
    }

    // Actions

    // Command

    sealed class Command
}
