package com.dkexception.newarchitecturewithhilt.logic

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.data.MainDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelFive @Inject constructor(
    private val mainDataSource: MainDataSource
) : BaseViewModel() {

    private val _textToDisplay = MutableLiveData(
        mainDataSource.getNumberFromScreen2() to mainDataSource.getDetails()?.toString()
    )
    val textToDisplay: LiveData<Pair<Int, String?>> get() = _textToDisplay

    fun onMainButtonClicked() {
        mainDataSource.setDetailsFromScreen4(null)
        goBackToScreen(
            destinyId = R.id.fragmentOne,
            inclusive = true
        )
    }
}
