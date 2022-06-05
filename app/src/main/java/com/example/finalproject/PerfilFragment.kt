package com.example.finalproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentPerfilBinding
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray

class PerfilFragment : Fragment() {
    private lateinit var binding: FragmentPerfilBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentPerfilBinding.inflate(layoutInflater)
        val database = Firebase.database
        val myRef = database.reference
        myRef.child("usuarios").get().addOnSuccessListener { response ->
            val resmap = response.value as ArrayList<Map <String, String>>
            Log.d("firebaseResponse", resmap.toString())
            val jsonarray = JSONArray(resmap)
            resmap.forEach{ usuario ->
                if(!usuario.isNullOrEmpty()){
                    Log.d("firebaseResponse", "titulo : ${usuario["nombre"]}")
                    binding.tvName.setText("${usuario["nombre"]}")
                    binding.tvLevel.setText("${usuario["nivel"]}")
                    binding.tvDate.setText("${usuario["fecha"]}")
                    binding.tvPhone.setText("${usuario["telefono"]}")
                    binding.tvEmail.setText("${usuario["correo"]}")
                }
            }}.addOnFailureListener{
            Log.e("firebaseResponse", "Error getting data", it)
        }
        return binding.root
    }


    }

