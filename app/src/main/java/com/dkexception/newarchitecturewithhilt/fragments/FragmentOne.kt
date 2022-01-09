package com.dkexception.newarchitecturewithhilt.fragments

import androidx.fragment.app.viewModels
import com.dkexception.newarchitecturewithhilt.databinding.FragmentOneBinding
import com.dkexception.newarchitecturewithhilt.logic.ViewModelOne
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentOne : BaseFragment<FragmentOneBinding, ViewModelOne>(
    FragmentOneBinding::inflate
) {

    override val viewModel: ViewModelOne by viewModels()

}
