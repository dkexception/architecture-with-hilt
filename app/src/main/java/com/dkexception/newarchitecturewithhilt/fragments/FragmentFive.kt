package com.dkexception.newarchitecturewithhilt.fragments

import androidx.fragment.app.viewModels
import com.dkexception.newarchitecturewithhilt.R
import com.dkexception.newarchitecturewithhilt.databinding.FragmentFiveBinding
import com.dkexception.newarchitecturewithhilt.extensions.setOnClickAction
import com.dkexception.newarchitecturewithhilt.logic.ViewModelFive
import com.dkexception.newarchitecturewithhilt.utils.Utils
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
        viewModel.textToDisplay.observe(viewLifecycleOwner, ::setDisplayText)
    }

    private fun setDisplayText(data: Pair<Int, String?>) = binding.tvDetails.run {
        append(getString(R.string.number_entered_display, data.first))
        append(System.getProperty(Utils.lineSeparator))
        append(System.getProperty(Utils.lineSeparator))
        data.second?.let {
            append(getString(R.string.your_details))
            append(System.getProperty(Utils.lineSeparator))
            append(it)
        }
    }
}
