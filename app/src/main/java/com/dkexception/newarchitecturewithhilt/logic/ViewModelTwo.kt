package com.dkexception.newarchitecturewithhilt.logic

import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.data.MainDataSource
import com.dkexception.newarchitecturewithhilt.data.Screen2ValidationModel
import com.dkexception.newarchitecturewithhilt.di.StandardDispatchers
import com.dkexception.newarchitecturewithhilt.fragments.FragmentTwoDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import javax.inject.Inject

@HiltViewModel
class ViewModelTwo @Inject constructor(
    private val mainDataSource: MainDataSource,
    private val standardDispatchers: StandardDispatchers
) : BaseViewModel() {

    private val numberFieldFlow = MutableStateFlow(0)

    fun onNumberFieldUpdated(number: String?) {
        val numberEntered = number?.toIntOrNull() ?: 0
        numberFieldFlow.value = numberEntered
    }

    fun onMainButtonClicked() = numberFieldFlow.value.run {
        mainDataSource.setNumberFromScreen2(this)
        navigateInDirection(
            if (this > 50) {
                FragmentTwoDirections.goToFragmentThree()
            } else {
                FragmentTwoDirections.goToFragmentFive()
            }
        )
    }

    fun validationFlow(
        optionalDispatcher: CoroutineDispatcher = standardDispatchers.defaultDispatcher
    ) = numberFieldFlow.map {

        val isNumberValid = isNumberValid(it)

        Screen2ValidationModel(
            numberFieldError = isNumberValid,
            shouldEnableButton = isNumberValid == null
        )

    }.flowOn(optionalDispatcher)

    private fun isNumberValid(number: Int): Int? {
        if (number !in 1..100) return R.string.enter_a_valid_number
        return null
    }
}
