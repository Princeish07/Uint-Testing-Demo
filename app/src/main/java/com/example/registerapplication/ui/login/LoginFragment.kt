package com.example.registerapplication.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.navigation.fragment.findNavController
import com.example.registerapplication.R
import com.example.registerapplication.data.model.LoginModel
import com.example.registerapplication.databinding.FragmentLoginBinding
import com.example.registerapplication.databinding.FragmentRegistrationBinding
import com.example.registerapplication.other.SharedPreferencesHelper
import com.example.registerapplication.other.Status


class LoginFragment : Fragment() {
    lateinit var viewModel: LoginViewModel;

    lateinit var binding: FragmentLoginBinding;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(inflater);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(LoginViewModel::class.java);
        observeListener();
        binding.btnSignUp1.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registrationFragment);
        }
        binding.btnLoginNow.setOnClickListener {
            viewModel.login(
                loginModel = LoginModel(
                    if (binding.etUserName.text.isEmpty()) "" else binding.etUserName.text.toString(),
                    if (binding.etPassword.text.isEmpty()) "" else binding.etPassword.text.toString()
                )
            )
        }
    }

    fun observeListener() {
        viewModel.loginResponse.observe(viewLifecycleOwner) {
            if (it.peekContent().status == Status.SUCCESS) {
                Toast.makeText(requireContext(), it.peekContent().message, Toast.LENGTH_SHORT).show()

                it.peekContent().data?.let { it1 ->

                    var getUserDetails = saveLoggedInUser("userName", it1.firstName);

                    if (getUserDetails!!.isNotEmpty()) {

                        Toast.makeText(requireContext(), "User $getUserDetails Successfully Saved In Shared Pref", Toast.LENGTH_SHORT).show()

                    } else {

                        Toast.makeText(requireContext(), "User not saved in shared pref", Toast.LENGTH_SHORT).show()
                    }
                }
            } else {

                Toast.makeText(requireContext(), it.peekContent().message, Toast.LENGTH_SHORT).show()

            }
        }
    }

    fun saveLoggedInUser(sharedPrefKey: String, value: String): String? {
        val sharedPreferencesHelper = SharedPreferencesHelper(requireContext())
        sharedPreferencesHelper.saveData(sharedPrefKey, value)
        val retrievedValue = sharedPreferencesHelper.getData("userName")
        return retrievedValue;

    }


}