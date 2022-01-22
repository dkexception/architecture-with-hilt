package com.dkexception.newarchitecturewithhilt.fragments

import androidx.core.widget.doAfterTextChanged
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.dkexception.newarchitecturewithhilt.databinding.FragmentFourBinding
import com.dkexception.newarchitecturewithhilt.extensions.setOnClickAction
import com.dkexception.newarchitecturewithhilt.logic.ViewModelFour
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class FragmentFour : BaseFragment<FragmentFourBinding, ViewModelFour>(
    FragmentFourBinding::inflate
) {

    override val viewModel: ViewModelFour by viewModels()

    override fun setupUI() {
        super.setupUI()
        setupTextChangeListeners()
        binding.btnFour.setOnClickAction(viewModel::onNextButtonClicked)
    }

    private fun setupTextChangeListeners() = binding.run {
        nameField.doAfterTextChanged {
            viewModel.setName(it.toString())
        }
        emailField.doAfterTextChanged {
            viewModel.setEmail(it.toString())
        }
        cityField.doAfterTextChanged {
            viewModel.setCity(it.toString())
        }
    }

    override fun setupVM() {
        super.setupVM()
        lifecycleScope.launch {
            viewModel.validationFlow().collect {

                if (it.nameError != null && binding.nameField.hasFocus())
                    binding.nameField.error = getString(it.nameError)
                else
                    binding.nameLayout.error = null

                if (it.emailError != null && binding.emailField.hasFocus())
                    binding.emailField.error = getString(it.emailError)
                else
                    binding.emailField.error = null

                if (it.cityError != null && binding.cityField.hasFocus())
                    binding.cityField.error = getString(it.cityError)
                else
                    binding.cityField.error = null

                binding.btnFour.isEnabled = it.shouldEnableButton
            }
        }
    }
}
