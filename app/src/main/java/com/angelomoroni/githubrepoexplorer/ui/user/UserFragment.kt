package com.angelomoroni.githubrepoexplorer.ui.user

import androidx.lifecycle.Observer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.angelomoroni.githubrepoexplorer.R
import com.angelomoroni.githubrepoexplorer.User
import kotlinx.android.synthetic.main.user_fragment.*
import org.koin.androidx.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }

    private val userViewModel:UserViewModel by viewModel()

    private val userObserver = Observer<User> {
        message.text = it.toString()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)



        userViewModel.user.observe(this, userObserver)
    }

}
