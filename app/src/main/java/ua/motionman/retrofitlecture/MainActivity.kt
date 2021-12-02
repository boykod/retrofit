package ua.motionman.retrofitlecture

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import ua.motionman.retrofitlecture.client.ApiClient
import ua.motionman.retrofitlecture.databinding.ActivityMainBinding
import ua.motionman.retrofitlecture.entities.GitHubUserResponse
import ua.motionman.retrofitlecture.services.GitHubService

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    private val gitHubService = ApiClient().retrofitClient.create(GitHubService::class.java)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        gitHubService.getUser("JakeWharton").enqueue(object : Callback<GitHubUserResponse> {
            override fun onResponse(
                call: Call<GitHubUserResponse>,
                response: Response<GitHubUserResponse>
            ) {
                binding.userNameTextView.text = response.body()?.name
            }

            override fun onFailure(call: Call<GitHubUserResponse>, t: Throwable) {
                Log.e("MainActivity", "onResponse: ${t.localizedMessage}")
            }
        })
    }
}