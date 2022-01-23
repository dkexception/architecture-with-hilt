package com.dkexception.newarchitecturewithhilt.fragments

import androidx.fragment.app.viewModels
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.databinding.FragmentThreeBinding
import com.dkexception.newarchitecturewithhilt.extensions.setOnClickAction
import com.dkexception.newarchitecturewithhilt.logic.ViewModelThree
import com.dkexception.newarchitecturewithhilt.utils.Utils
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentThree : BaseFragment<FragmentThreeBinding, ViewModelThree>(
    FragmentThreeBinding::inflate
) {

    override val viewModel: ViewModelThree by viewModels()

    override fun setupUI() = binding.run {
        super.setupUI()
        tvNumberDisplay.text =
            getString(R.string.entered_number, viewModel.numberEnteredInScreen2)
        tvNumberDisplay.append(System.getProperty(Utils.lineSeparator))
        tvNumberDisplay.append(System.getProperty(Utils.lineSeparator))
        tvNumberDisplay.append(getString(R.string.enter_details_rationale))
        btnThree.setOnClickAction(viewModel::onMainButtonClicked)
    }
}
