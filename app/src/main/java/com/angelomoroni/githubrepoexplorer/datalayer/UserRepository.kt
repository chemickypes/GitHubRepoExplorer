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
            val ll = userDao.load(username)

            if(ll?.value != null){
                Log.d(javaClass.name,"from DB")
                liveData.value = User(ll.value!!)
            } else {

                var nnuser : User? = null


                async(Dispatchers.IO) {
                    val r = webService.getUser(username).execute()

                    if(r.isSuccessful){
                        Log.d(javaClass.name,"from server")
                        nnuser = r?.body()?.let {
                            userDao.save(UserEntity(it))
                            it
                        }
                    }
                }.await()



                liveData.value = nnuser!!


            }
        }




        return liveData
    }

}