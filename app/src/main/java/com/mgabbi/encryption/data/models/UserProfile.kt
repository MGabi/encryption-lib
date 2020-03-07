package com.mgabbi.encryption.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class UserProfile(
    @SerializedName("email")
    val email: String? = null
) : Parcelable
