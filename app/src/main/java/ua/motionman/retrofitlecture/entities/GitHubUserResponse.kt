package ua.motionman.retrofitlecture.entities

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class GitHubUserResponse(
    val login: String,
    @Json(name = "html_url")
    val url: String,
    @Json(name = "avatar_url")
    val avatar: String,
    val name: String,
    val email: String?,
    val followers: Int,
    val following: Int,
    val location: String,
    @Json(name = "public_repos")
    val publicRepos: Int,
    @Json(name = "public_gists")
    val publicGists: Int
)
