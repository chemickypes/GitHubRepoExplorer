package com.angelomoroni.githubrepoexplorer.datalayer

import com.angelomoroni.githubrepoexplorer.User
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface GitHubWebService{
    @GET("/users/{user}")
    fun getUser(@Path("user") username: String) : Call<User>
}



