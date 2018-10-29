package com.angelomoroni.githubrepoexplorer.ui.user

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.angelomoroni.githubrepoexplorer.User
import com.angelomoroni.githubrepoexplorer.datalayer.Bundle
import com.angelomoroni.githubrepoexplorer.datalayer.UserRepository

class UserViewModel(val userRepository: UserRepository) : ViewModel() {


    val user : LiveData<Bundle<User>> by lazy {
        userRepository.getUser("siralam")
    }
}
