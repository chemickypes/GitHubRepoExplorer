package com.angelomoroni.githubrepoexplorer.datalayer

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import com.angelomoroni.githubrepoexplorer.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserRepository{

    private val webService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GitHubWebService::class.java)
    }

    fun getUser(username:String): LiveData<User> {
        val liveData = MutableLiveData<User>()

        webService.getUser(username).enqueue ( object : Callback<User>{
            override fun onFailure(call: Call<User>, t: Throwable) {
                t.printStackTrace()
            }

            override fun onResponse(call: Call<User>, response: Response<User>) {
                liveData.value = response.body()
            }

        })
        return liveData
    }

}