package com.angelomoroni.githubrepoexplorer.ui.user

import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.angelomoroni.githubrepoexplorer.R
import org.koin.android.viewmodel.ext.android.viewModel

class UserFragment : Fragment() {

    companion object {
        fun newInstance() = UserFragment()
    }

    val userViewModel:UserViewModel by viewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return inflater.inflate(R.layout.user_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

    }

}
