package com.dkexception.newarchitecturewithhilt.logic

import com.dkexception.newarchitecturewithhilt.data.MainDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class ViewModelTwo @Inject constructor(
    private val mainDataSource: MainDataSource
) : BaseViewModel() {

}
