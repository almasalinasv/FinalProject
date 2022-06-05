package com.example.finalproject

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.finalproject.databinding.FragmentBusquedaBinding
import com.example.finalproject.remote.ProductEntry
import com.example.finalproject.remote.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class BusquedaFragment : Fragment() {

    lateinit var binding: FragmentBusquedaBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?

    ): View? {
        binding = FragmentBusquedaBinding.inflate(layoutInflater)
        binding.btnBusqueda.setOnClickListener {
            val id = binding.etBusqueda.text.toString()
            val retrofit = RetrofitBuilder.create().getProductById("${id}")


            retrofit.enqueue(object : Callback<ProductEntry> {
                override fun onResponse(
                    call: Call<ProductEntry>,
                    response: Response<ProductEntry>
                ) {

                    val titulo = response.body()?.title
                    if (titulo != null) {
                        Log.d("retrofitresponse", "titulo: ${titulo}")

                        binding.tvName.setText(titulo)

                    }
                    val precio = response.body()?.price
                    if (precio != null) {
                        Log.d("retrofitresponse", "precio: ${precio}")
                        binding.tvPrecio.setText(precio.toString())
                    }
                    val descripcion = response.body()?.description
                    if (descripcion != null) {
                        Log.d("retrofitresponse", "titulo: ${descripcion}")
                        binding.tvDescripcion.setText(descripcion)
                    }
                    val score = response.body()?.rating
                    if (descripcion != null) {
                        Log.d("retrofitresponse", "titulo: ${score}")
                        binding.tvScore.setText(score.toString())
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