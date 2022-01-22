package com.dkexception.newarchitecturewithhilt.logic

import androidx.core.util.PatternsCompat
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.data.DetailsHolder
import com.dkexception.newarchitecturewithhilt.data.MainDataSource
import com.dkexception.newarchitecturewithhilt.data.Screen4ValidationModel
import com.dkexception.newarchitecturewithhilt.di.StandardDispatchers
import com.dkexception.newarchitecturewithhilt.fragments.FragmentFourDirections
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

@HiltViewModel
class ViewModelFour @Inject constructor(
    private val mainDataSource: MainDataSource,
    private val standardDispatchers: StandardDispatchers
) : BaseViewModel() {

    private val nameFlow = MutableStateFlow("")
    private val emailFlow = MutableStateFlow("")
    private val cityFlow = MutableStateFlow("")

    fun setName(name: String) {
        nameFlow.value = name
    }

    fun setEmail(email: String) {
        emailFlow.value = email
    }

    fun setCity(city: String) {
        cityFlow.value = city
    }

    fun validationFlow(
        dispatcher: CoroutineDispatcher = standardDispatchers.defaultDispatcher
    ) = combine(nameFlow, emailFlow, cityFlow) { name, email, city ->

        val nameValid = validateName(name)
        val emailValid = validateEmail(email)
        val cityValid = validateCity(city)

        Screen4ValidationModel(
            nameError = nameValid,
            emailError = emailValid,
            cityError = cityValid,
            shouldEnableButton = (nameValid == null) && (emailValid == null) && (cityValid == null)
        )
    }.flowOn(dispatcher)

    private fun validateName(name: String): Int? {
        if (name.length !in 2..20) return R.string.invalid_name
        return null
    }

    private fun validateEmail(email: String): Int? {
        if (email.isBlank()) return R.string.invalid_email
        val isValidEmail = PatternsCompat.EMAIL_ADDRESS.matcher(email).matches()
        if (isValidEmail) return null
        return R.string.invalid_email
    }

    private fun validateCity(city: String): Int? {
        if (city.length !in 2..20) return R.string.invalid_city
        return null
    }

    fun onNextButtonClicked() {
        mainDataSource.setDetailsFromScreen4(
            DetailsHolder(
                name = nameFlow.value,
                email = emailFlow.value,
                city = cityFlow.value
            )
        )
        navigateInDirection(FragmentFourDirections.goToFragmentFive())
    }
}
