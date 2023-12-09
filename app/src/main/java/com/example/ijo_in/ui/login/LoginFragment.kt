package com.example.ijo_in.ui.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.ijo_in.R
import com.example.ijo_in.databinding.FragmentLoginBinding
import org.koin.android.ext.android.inject


class LoginFragment : Fragment() {


    private  var _binding: FragmentLoginBinding? = null
    private val binding get() = _binding!!
    private val viewModel: LoginViewModel by inject()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        init()
        observeData()

        return binding.root
    }

    private fun observeData() {
        with(viewModel) {
//            observeIsLogin().observe(requireActivity()) { data ->
//                if (data != null) {
//                    findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment)
//                }
//            }
            observeIsLogin().observe(requireActivity()) {
                it.let { data ->
                    if (data != null) {
                        if (isAdded) {
                            findNavController().navigate(R.id.action_loginFragment_to_navigationParentFragment)
                        }

                    }
                }
            }
        }
    }
//            observeErrorMessage().observe(requireActivity()) { message ->
//                if (!message.isNullOrBlank()) {
//                    Toast.makeText(requireContext(), message, Toast.LENGTH_SHORT).show()
//                    Log.d("LoginFragment", "observeData: $message")
//                }
//            }
//        }



    private fun init() {
        with(binding){
            btnLogin.setOnClickListener {
                if(etEmail.text.isNullOrBlank()){
                    etEmail.error = "Email tidak boleh kosong"
                }
                if(etPassword.text.isNullOrBlank()) {
                    etPassword.error = "Password tidak boleh kosong"
                }
                if (!etEmail.text.isNullOrBlank() && !etPassword.text.isNullOrBlank()){
                    viewModel.getDataLogin(etEmail.text.toString(), etPassword.text.toString())
                }
            }


            tvSignup.setOnClickListener(){
                findNavController().navigate(R.id.action_loginFragment_to_regisFragment)
            }

        }
    }

}