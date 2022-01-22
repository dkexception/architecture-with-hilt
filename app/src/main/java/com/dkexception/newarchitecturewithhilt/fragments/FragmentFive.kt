package com.dkexception.newarchitecturewithhilt.fragments

import androidx.fragment.app.viewModels
import com.dkexception.newarchitecturewithhilt.data.DetailsHolder
import com.dkexception.newarchitecturewithhilt.databinding.FragmentFiveBinding
import com.dkexception.newarchitecturewithhilt.extensions.setOnClickAction
import com.dkexception.newarchitecturewithhilt.logic.ViewModelFive
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class FragmentFive : BaseFragment<FragmentFiveBinding, ViewModelFive>(
    FragmentFiveBinding::inflate
) {

    override val viewModel: ViewModelFive by viewModels()

    override fun setupUI() {
        super.setupUI()
        binding.btnFive.setOnClickAction(viewModel::onMainButtonClicked)
    }

    override fun setupVM() {
        super.setupVM()
        viewModel.detailsPresent.observe(viewLifecycleOwner, ::showPresentDetails)
    }

    private fun showPresentDetails(details: DetailsHolder) = binding.run {
        tvDetails.append("${System.getProperty("line.separator")}$details")
    }
}
