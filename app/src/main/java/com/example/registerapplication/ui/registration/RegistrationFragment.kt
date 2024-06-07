package com.example.registerapplication.ui.registration

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.navigation.fragment.findNavController
import com.example.registerapplication.data.model.RegistrationModel
import com.example.registerapplication.databinding.FragmentRegistrationBinding
import com.example.registerapplication.other.Status


class RegistrationFragment : Fragment() {
    lateinit var binding: FragmentRegistrationBinding;

    lateinit var viewModel: RegistrationViewModel;

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
         binding = FragmentRegistrationBinding.inflate(inflater);
        return binding.root;
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
         viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)
        observeListener()
        binding.btnLogin.setOnClickListener {
            findNavController().popBackStack();

        }

        binding.btnRegisterNow.setOnClickListener {
            viewModel.registerNow(RegistrationModel(firstName = binding.etFirstName.text.toString(), lastName = binding.etLastName.text.toString(), email = binding.etEmail.text.toString(), password = binding.etPassword.text.toString(), confirmPassword = binding.etConfirmPassword.text.toString()));


        }
    }


    fun observeListener(){
        viewModel.registrationResponse.observe(viewLifecycleOwner){
            if(it.peekContent().status==Status.SUCCESS){
                Toast.makeText(requireContext(), "Registration Successful", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), it.peekContent().message, Toast.LENGTH_SHORT).show()

            }
        }
    }

}