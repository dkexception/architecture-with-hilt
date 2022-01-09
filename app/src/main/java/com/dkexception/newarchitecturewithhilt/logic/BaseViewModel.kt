package com.dkexception.newarchitecturewithhilt.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavDirections
import androidx.navigation.NavOptions
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.utils.SingleLiveEvent

abstract class BaseViewModel : ViewModel() {

    private val defaultNavOptions = NavOptions.Builder()
        .setEnterAnim(R.anim.slide_in_right)
        .setExitAnim(R.anim.slide_out_left)
        .setPopEnterAnim(android.R.anim.slide_in_left)
        .setPopExitAnim(android.R.anim.slide_out_right)
        .build()

    val loaderState: LiveData<Boolean> get() = _loaderState
    private val _loaderState = MutableLiveData<Boolean>()

    val toastableError: LiveData<String?> get() = mToastableError
    private val mToastableError = SingleLiveEvent<String?>()

    val navigationEvent: LiveData<NavController.() -> Any> get() = _navigationEvent
    private val _navigationEvent = SingleLiveEvent<NavController.() -> Any>()

    val finishRequest: LiveData<Unit> get() = _finishRequest
    private val _finishRequest = SingleLiveEvent<Unit>()

    protected fun showToast(message: String?) = mToastableError.postValue(message)

    protected fun navigateInDirection(directions: NavDirections) {
        _navigationEvent.postValue {
            navigate(directions, defaultNavOptions)
        }
    }

    protected fun navigateUp() {
        _navigationEvent.postValue {
            navigateUp()
        }
    }

    protected fun showLoader() = _loaderState.postValue(true)

    protected fun hideLoader() = _loaderState.postValue(false)

    protected fun finishActivity() = _finishRequest.postValue(Unit)
}
