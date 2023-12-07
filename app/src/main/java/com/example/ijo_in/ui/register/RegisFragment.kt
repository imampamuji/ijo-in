package com.example.ijo_in.ui.register

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.viewModelScope
import androidx.navigation.fragment.findNavController
import com.example.ijo_in.R
import com.example.ijo_in.data.local.UserEntity
import com.example.ijo_in.databinding.FragmentRegisBinding
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

class RegisFragment : Fragment() {

    private var _binding: FragmentRegisBinding? = null

    private val binding get() = _binding!!
    private lateinit var viewModel: RegisterViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentRegisBinding.inflate(inflater, container, false)
        viewModel = RegisterViewModel(application = requireActivity().application)

        binding.btnRegis.setOnClickListener {

            val name = binding.etName.text.toString()
            val email = binding.etEmail.text.toString()
            val pass = binding.etPass.text.toString()

            val user = UserEntity(0, name, email, pass)
            CoroutineScope(viewModel.viewModelScope.coroutineContext).launch {
                viewModel.insertUser(user)
            }
            findNavController().navigate(R.id.action_regisFragment_to_navigationParentFragment)
            Log.d("regis", "name ${name}")
        }

        return binding.root
    }

}