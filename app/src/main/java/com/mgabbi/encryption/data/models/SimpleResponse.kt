package com.mgabbi.encryption.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimpleResponse(
    val response: String
) : Parcelable
