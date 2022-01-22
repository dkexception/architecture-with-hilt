package com.dkexception.newarchitecturewithhilt.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.data.DetailsHolder
import com.dkexception.newarchitecturewithhilt.data.MainDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelFive @Inject constructor(
    private val mainDataSource: MainDataSource
) : BaseViewModel() {

    private val _detailsPresent = MutableLiveData<DetailsHolder>()
    val detailsPresent: LiveData<DetailsHolder> get() = _detailsPresent

    init {
        mainDataSource.getDetails()?.run(_detailsPresent::postValue)
    }

    fun onMainButtonClicked() {
        mainDataSource.setDetailsFromScreen4(null)
        goBackToScreen(
            destinyId = R.id.fragmentOne,
            inclusive = true
        )
    }
}
