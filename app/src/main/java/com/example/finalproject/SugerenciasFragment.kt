package com.example.finalproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentSugerenciasBinding
import com.example.finalproject.remote.ProductEntry
import com.example.finalproject.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import kotlin.random.Random


class SugerenciasFragment : Fragment() {
    private lateinit var binding: FragmentSugerenciasBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentSugerenciasBinding.inflate(layoutInflater)

        for (i in 1..5) {
            val id = Random.nextInt(0, 20).toString()
            val retrofit = RetrofitBuilder.create().getProductById(id)


            retrofit.enqueue(object : Callback<ProductEntry> {
                override fun onResponse(
                    call: Call<ProductEntry>, response: retrofit2.Response<ProductEntry>
                ) {
                    val resBody = response.body().toString()
                    if (resBody != null) {
                        Log.d("retrofitresponse", "res:  ${response.body()}")
                    }
                }

                override fun onFailure(call: Call<ProductEntry>, t: Throwable) {
                    Log.e("retrofitresponse", "error: ${t.message}")
                }
            })
        }
        return binding.root
    }

}