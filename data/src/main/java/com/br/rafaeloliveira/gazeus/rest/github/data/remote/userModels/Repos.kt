package com.br.rafaeloliveira.gazeus.rest.github.data.remote.userModels

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class Repos(
    @SerializedName("id") val id : Int,
    @SerializedName("node_id") val nodeId : String,
    @SerializedName("name") val name : String,
    @SerializedName("full_name") val fullName : String,
    @SerializedName("private") val private : Boolean,
    @SerializedName("owner") val owner : Owner
) : Parcelable

@Keep
@Parcelize
data class Owner(
    @SerializedName("login") val login : String
): Parcelable
