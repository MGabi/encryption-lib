package com.mgabbi.encryption.data.models

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class SimpleRequest(
    val request: String
) : Parcelable

@Parcelize
data class SimpleResponse(
    val response: String
) : Parcelable
