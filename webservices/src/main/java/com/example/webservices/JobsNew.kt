package com.example.webservices

import com.google.gson.annotations.SerializedName

data class JobsNew(
    @SerializedName("uuid") val uuid: String,
    @SerializedName("title") val title: String,
    @SerializedName("normalized_job_title") val normalizedJobTitle: String,
    @SerializedName("parent_uuid") val parentUuid: String,
    @SerializedName("links") val links: List<Link>
)