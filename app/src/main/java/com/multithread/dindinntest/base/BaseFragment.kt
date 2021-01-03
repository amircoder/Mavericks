package com.multithread.dindinntest.base

import android.content.Context
import com.airbnb.mvrx.BaseMvRxFragment
import dagger.android.support.AndroidSupportInjection


abstract class BaseFragment :
    BaseMvRxFragment(){

    override fun onAttach(context: Context) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    fun showLoading(loading: Boolean){

    }

    fun onError(errorMessage: String){

    }

}