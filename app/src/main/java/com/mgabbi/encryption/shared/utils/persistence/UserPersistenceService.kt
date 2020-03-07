package com.mgabbi.encryption.shared.utils.persistence

import com.orhanobut.hawk.Hawk
import com.mgabbi.encryption.data.models.Token
import com.mgabbi.encryption.data.models.UserProfile
import com.mgabbi.encryption.shared.utils.persistence.HawkKeys

interface UserPersistenceService {

    var userProfile: UserProfile?
        get() = Hawk.get(HawkKeys.USER_PROFILE)
        set(user) {
            Hawk.put(HawkKeys.USER_PROFILE, user)
        }

    var token: Token?
        get() = Hawk.get(HawkKeys.TOKEN_KEY)
        set(token) {
            Hawk.put(HawkKeys.TOKEN_KEY, token)
        }

    fun discardData() {
        Hawk.delete(HawkKeys.USER_PROFILE)
    }

    fun UserProfile.persist() {
        userProfile = this
    }
}
