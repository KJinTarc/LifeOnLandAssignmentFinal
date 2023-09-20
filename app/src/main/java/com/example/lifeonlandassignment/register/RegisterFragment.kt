package com.example.lifeonlandassignment.register

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.lifeonlandassignment.R
import com.example.lifeonlandassignment.database.AssignmentDatabase
import com.example.lifeonlandassignment.database.AssignmentDatabaseRepository
import com.example.lifeonlandassignment.databinding.RegisterScreenBinding

class RegisterFragment : Fragment() {
    private lateinit var registerViewModel: RegisterViewModel
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: RegisterScreenBinding = DataBindingUtil.inflate(
            inflater, R.layout.register_screen, container, false)
        val application = requireNotNull(this.activity).application
        val dataSource = AssignmentDatabase.getInstance(application).assignmentDatabaseDao
        val repository = AssignmentDatabaseRepository(dataSource)
        val factory = RegisterViewModelFactory(repository, application)
        registerViewModel = ViewModelProvider(this,factory).get(RegisterViewModel::class.java)
        binding.registerViewModel = registerViewModel
        binding.lifecycleOwner = this

        registerViewModel.messageLiveData.observe(this, Observer { message ->
            message?.let {
                // Display a Toast with the message
                Toast.makeText(this, message, Toast.LENGTH_SHORT).show()
            }
        })

        return binding.root
    }
}