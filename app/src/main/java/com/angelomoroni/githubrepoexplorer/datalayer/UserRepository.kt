package com.angelomoroni.githubrepoexplorer.datalayer

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import android.util.Log
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

    fun getUser(username:String): LiveData<User> {
        val liveData = MutableLiveData<User>()


        GlobalScope.launch(Dispatchers.Main) {



            var nnuser : User? = null


            async(Dispatchers.IO) {
                val prova = userDao.loadAll()

                val u = userDao.load(username)

                if(u != null) {
                    nnuser = User(u)
                }else {
                    val r = webService.getUser(username).execute()

                    if (r.isSuccessful) {
                        Log.d(javaClass.name, "from server")
                        nnuser = r?.body()?.let {
                            userDao.save(UserEntity(it))
                            it
                        }
                    }
                }
            }.await()

            liveData.value = nnuser!!

        }




        return liveData
    }

}