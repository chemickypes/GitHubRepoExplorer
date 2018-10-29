package com.angelomoroni.githubrepoexplorer.datalayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
import androidx.lifecycle.Transformations
import com.angelomoroni.githubrepoexplorer.User
import com.angelomoroni.githubrepoexplorer.UserEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.async
import kotlinx.coroutines.launch
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

    fun getUser(username:String): LiveData<Bundle<User>> {

        val livedata = Transformations.map(userDao.load(username)!!){
            Log.d(UserRepository::javaClass.name, "from db")
            if (it == null){
                Bundle(exception = NullPointerException())
            }else {
                Bundle(value = User(it))
            }
        }


        GlobalScope.launch(Dispatchers.Main) {

            async(Dispatchers.IO) {
                val r = webService.getUser(username).execute()

                if (r.isSuccessful) {
                    Log.d(UserRepository::javaClass.name, "from server")
                    r?.body()?.let {
                        userDao.save(UserEntity(it))
                        it
                    }
                }
            }.await()

        }

        return livedata
    }

}