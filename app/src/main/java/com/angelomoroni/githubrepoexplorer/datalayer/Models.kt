package com.angelomoroni.githubrepoexplorer.datalayer

import java.lang.Exception


class Bundle<T> (val value: T? = null, val exception: Exception? = null, val isLoading: Boolean = false)