package com.dkexception.newarchitecturewithhilt.logic

import com.dkexception.newarchitecturewithhilt.fragments.FragmentOneDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelOne @Inject constructor() : BaseViewModel() {

    fun onMainButtonClicked() = navigateInDirection(
        FragmentOneDirections.goToFragmentTwo()
    )
}
