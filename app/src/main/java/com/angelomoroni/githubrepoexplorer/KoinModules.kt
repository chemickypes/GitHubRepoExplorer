package com.angelomoroni.githubrepoexplorer

import android.app.Application
import com.angelomoroni.githubrepoexplorer.datalayer.UserRepository
import com.angelomoroni.githubrepoexplorer.ui.user.UserViewModel
import org.koin.android.ext.android.startKoin
import org.koin.android.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module


val appModule = module {

    single {
        UserRepository()
    }

    viewModel {
        UserViewModel(get())
    }


}

class GitHubExplorerApp: Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin(this, listOf(appModule))
    }
}