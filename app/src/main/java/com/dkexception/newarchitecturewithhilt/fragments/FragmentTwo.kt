package com.dkexception.newarchitecturewithhilt.fragments

import androidx.fragment.app.viewModels
import com.dkexception.newarchitecturewithhilt.databinding.FragmentTwoBinding
import com.dkexception.newarchitecturewithhilt.logic.ViewModelTwo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentTwo : BaseFragment<FragmentTwoBinding, ViewModelTwo>(
    FragmentTwoBinding::inflate
) {

    override val viewModel: ViewModelTwo by viewModels()

}