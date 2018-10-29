package com.angelomoroni.githubrepoexplorer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.angelomoroni.githubrepoexplorer.ui.user.UserFragment

class UserActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.user_activity)
        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, UserFragment.newInstance())
                .commitNow()
        }
    }

}
