package com.dkexception.newarchitecturewithhilt.logic

import com.dkexception.newarchitecturewithhilt.data.MainDataSource
import com.dkexception.newarchitecturewithhilt.fragments.FragmentThreeDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelThree @Inject constructor(
    mainDataSource: MainDataSource
) : BaseViewModel() {

    val numberEnteredInScreen2 = mainDataSource.getNumberFromScreen2()

    fun onMainButtonClicked() = navigateInDirection(FragmentThreeDirections.goToFragmentFour())
}
