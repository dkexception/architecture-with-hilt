package com.dkexception.newarchitecturewithhilt.fragments

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dkexception.newarchitecturewithhilt.databinding.FragmentTwoBinding
import com.dkexception.newarchitecturewithhilt.extensions.setOnClickAction
import com.dkexception.newarchitecturewithhilt.logic.ViewModelTwo
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentTwo : BaseFragment<FragmentTwoBinding, ViewModelTwo>(
    FragmentTwoBinding::inflate
) {

    override val viewModel: ViewModelTwo by viewModels()

    override fun setupUI() {
        super.setupUI()
        binding.numberField.clearFocus()
        setupObservers()
    }

    private fun setupObservers() {
        binding.numberField.doAfterTextChanged {
            val enteredText = it?.toString()
            viewModel.onNumberFieldUpdated(enteredText)
        }
        binding.btnTwo.setOnClickAction(viewModel::onMainButtonClicked)
    }

    override fun setupVM() {
        super.setupVM()
        collectFlow()
    }

    private fun collectFlow() {
        lifecycleScope.launch {
            viewModel.validationFlow().collect {
                if (it.numberFieldError != null && binding.numberField.hasFocus())
                    binding.numberField.error = getString(it.numberFieldError)
                else
                    binding.numberField.error = null
                binding.btnTwo.isEnabled = it.shouldEnableButton
            }
        }
    }
}
