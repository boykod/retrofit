package ua.motionman.retrofitlecture.services

import okhttp3.Interceptor
import okhttp3.Response

class AuthorizationInterceptor : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
        return with(chain.request().newBuilder()) {
            addHeader("Authorization", "Bearer `your api`")
            chain.proceed(build())
        }
    }
}