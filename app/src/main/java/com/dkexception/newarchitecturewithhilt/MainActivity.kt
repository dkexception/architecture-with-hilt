package com.dkexception.newarchitecturewithhilt

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.dkexception.newarchitecturewithhilt.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun reactOnToast(message: String?) = Toast.makeText(
        this,
        message ?: getString(R.string.generic_error),
        Toast.LENGTH_SHORT
    ).show()

    fun toggleProgressDialog(isVisible: Boolean) {
        // todo later
    }
}
