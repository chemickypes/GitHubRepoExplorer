package com.angelomoroni.githubrepoexplorer.ui.user

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.angelomoroni.githubrepoexplorer.User
import com.angelomoroni.githubrepoexplorer.datalayer.UserRepository

class UserViewModel(var userRepository: UserRepository) : ViewModel() {


    val user : LiveData<User> by lazy {
        userRepository.getUser("chemickypes")
    }
}
