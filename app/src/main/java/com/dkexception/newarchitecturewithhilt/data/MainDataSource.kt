package com.dkexception.newarchitecturewithhilt.data

import dagger.hilt.android.scopes.ActivityRetainedScoped
import javax.inject.Inject

@ActivityRetainedScoped
class MainDataSource @Inject constructor() {

    private var numberEnteredInScreen2: Int? = null

    fun setNumberFromScreen2(number: Int) {
        numberEnteredInScreen2 = number
    }

    fun getNumberFromScreen2() = numberEnteredInScreen2 ?: 0

    private var details: DetailsHolder? = null

    fun setDetailsFromScreen4(detailsHolder: DetailsHolder?) {
        details = detailsHolder
    }

    fun getDetails() = details?.copy()
}

data class DetailsHolder(
    val name: String,
    val email: String,
    val city: String
)
