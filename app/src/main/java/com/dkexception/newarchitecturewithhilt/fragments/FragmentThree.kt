package com.dkexception.newarchitecturewithhilt.fragments

import androidx.fragment.app.viewModels
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.databinding.FragmentThreeBinding
import com.dkexception.newarchitecturewithhilt.extensions.setOnClickAction
import com.dkexception.newarchitecturewithhilt.logic.ViewModelThree
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentThree : BaseFragment<FragmentThreeBinding, ViewModelThree>(
    FragmentThreeBinding::inflate
) {

    override val viewModel: ViewModelThree by viewModels()

    override fun setupUI() {
        super.setupUI()
        binding.tvNumberDisplay.text =
            getString(R.string.entered_number, viewModel.numberEnteredInScreen2)
        binding.btnThree.setOnClickAction(viewModel::onMainButtonClicked)
    }
}
