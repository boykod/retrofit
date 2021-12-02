package ua.motionman.retrofitlecture.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query
import ua.motionman.retrofitlecture.entities.GitHubUserResponse

interface GitHubService {
    @GET("users/{user}")
    fun getUser(@Path("user") user: String): Call<GitHubUserResponse>
}