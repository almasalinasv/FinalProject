package com.example.finalproject

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.example.finalproject.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater,container, false)
        val navController = findNavController()

        binding.btnHomeToInside.setOnClickListener {
            Toast.makeText(context,"Entrando...",Toast.LENGTH_SHORT).show()
            val directions = HomeFragmentDirections.actionHomeFragmentToPerfilFragment()
            navController.navigate(directions)
        }

        return binding.root
    }

}