package com.br.rafaeloliveira.gazeus.rest.github.data.remote.tagModels

import android.os.Parcelable
import androidx.annotation.Keep
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Keep
@Parcelize
data class TagRepo(
    @SerializedName("name") val name : String? = "",
    @SerializedName("commit") val commit: Commit? = null,
    @SerializedName("zipball_url") val zipballUrl : String? = "",
    @SerializedName("tarball_url") val tarballUrl : String? = "",
    @SerializedName("node_id") val nodeId : String? = ""
 ): Parcelable

@Keep
@Parcelize
data class Commit(
    @SerializedName("sha") val sha : String? = "" ,
    @SerializedName("url") val url : String? = ""
) :Parcelable
