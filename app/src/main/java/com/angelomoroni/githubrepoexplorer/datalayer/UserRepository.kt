package com.angelomoroni.githubrepoexplorer.datalayer

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import com.angelomoroni.githubrepoexplorer.User
import com.angelomoroni.githubrepoexplorer.UserEntity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class UserRepository(val userDao: UserDao ){



    private val webService by lazy {
        Retrofit.Builder()
            .baseUrl("https://api.github.com")
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
            .create(GitHubWebService::class.java)
    }

    fun getUser(username:String): LiveData<User> {
        val liveData = MutableLiveData<User>()


        val ll = userDao.load(username)

        if(ll?.value != null){
            Log.d(javaClass.name,"from DB")
            liveData.value = User(ll.value!!)
        }else {


            webService.getUser(username).enqueue(object : Callback<User> {
                override fun onFailure(call: Call<User>, t: Throwable) {
                    t.printStackTrace()
                }

                override fun onResponse(call: Call<User>, response: Response<User>) {
                    response.body()?.let {

                        Log.d(javaClass.name,"from server")
                        userDao.save(UserEntity(it))
                        liveData.value = it
                    }


                }

            })
        }
        return liveData
    }

}