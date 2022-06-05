package com.example.finalproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.setupWithNavController
import com.android.volley.RequestQueue
import com.android.volley.toolbox.Volley
import com.example.finalproject.databinding.ActivityMainBinding
import com.example.finalproject.databinding.FragmentPerfilBinding
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase
import org.json.JSONArray

class MainActivity : AppCompatActivity() {

    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)



        val navView: BottomNavigationView = findViewById(R.id.bottomNavigationView)
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val navController = navHostFragment.findNavController()
        navView.setupWithNavController(navController)

        val database = Firebase.database
        val myRef = database.reference

        myRef.child("usuarios").child("1")
            .setValue(Usuarios("Alma", 1, "21/05/2022", "4434834735", "almasv@mail.com"))
        myRef.child("usuarios").child("2")
            .setValue(Usuarios("Rebeca", 2, "14/05/2022", "4431296260", "rebecasv@mail.com"))
        myRef.child("usuarios").child("3")
            .setValue(Usuarios("Artemio", 3, "01/06/2022", "4434043092", "artemiosreyes@mail.com"))

    }

}