package com.angelomoroni.githubrepoexplorer

import android.app.Application
import androidx.room.Room
import com.angelomoroni.githubrepoexplorer.datalayer.UserDatabase
import com.angelomoroni.githubrepoexplorer.datalayer.UserRepository
import com.angelomoroni.githubrepoexplorer.ui.user.UserViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModule = module {

    single {
        UserRepository(get())
    }

    viewModel {
        UserViewModel(get())
    }

    factory {
        Room.databaseBuilder(androidApplication(), UserDatabase::class.java, "users-db")
            .build()
    }

    //UserDao
    single { get<UserDatabase>().userDao() }



}

class GitHubExplorerApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}