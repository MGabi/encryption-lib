package com.mgabbi.encryption.data.models

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Token(
    @SerializedName("access_token")
    val accessToken: String,
    @SerializedName("token_type")
    val tokenType: String,
    @SerializedName("expires_in")
    val expiresIn: Double,
    @SerializedName("scope")
    val scope: String,
    @SerializedName("created_at")
    val createdAt: Double
) : Parcelable
