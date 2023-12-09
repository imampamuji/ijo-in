package com.example.ijo_in.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.ijo_in.R
import com.example.ijo_in.databinding.FragmentNavigationParentBinding
import com.example.ijo_in.ui.home.HomeFragment

class NavigationParentFragment : Fragment() {

    private var _binding: FragmentNavigationParentBinding? = null

    private val binding get() = _binding!!



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentNavigationParentBinding.inflate(inflater, container, false)

        val homeFragment = HomeFragment()
        val profileFragment = ProfileFragment()

        setCurrentFragment(homeFragment)

        binding.bottomNavigationView.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.nav_home -> setCurrentFragment(homeFragment)
                R.id.nav_profile -> setCurrentFragment(profileFragment)
            }
            true
        }
        return binding.root

    }

    private fun setCurrentFragment(fragment: Fragment){
        requireActivity().supportFragmentManager.beginTransaction().apply {
            replace(R.id.parent_fragment, fragment)
            commit()
        }
    }

}