package com.mgabbi.encryption.core.home

import androidx.lifecycle.LiveData
import androidx.navigation.NavDirections
import com.mgabbi.encryption.shared.base.BaseViewModel
import com.mgabbi.encryption.shared.utils.LiveEvent

class HomeViewModel : BaseViewModel() {

    // Properties

    private val _cmd = LiveEvent<Command>()
    val cmd: LiveData<Command> = _cmd

    fun openLocalEncryptionFr() {
        _cmd.value = Command.Navigate(HomeFragmentDirections.actionHomeFragmentToNoApiFragment())
    }

    fun openRemoteEncryptionFr() {
        _cmd.value = Command.Navigate(HomeFragmentDirections.actionHomeFragmentToRemoteCallFragment())
    }

    sealed class Command {
        class Navigate(val direction: NavDirections) : Command()
    }
}
