package com.dkexception.newarchitecturewithhilt.data

data class Screen2ValidationModel(
    val numberFieldError: Int?,
    val shouldEnableButton: Boolean
)

data class Screen4ValidationModel(
    val nameError: Int?,
    val emailError: Int?,
    val cityError: Int?,
    val shouldEnableButton: Boolean
)
