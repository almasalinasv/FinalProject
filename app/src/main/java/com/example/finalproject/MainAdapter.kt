package com.example.finalproject

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.finalproject.databinding.ItemProductBinding
import org.json.JSONArray
import org.json.JSONObject

class MainAdapter(private val info: JSONArray): RecyclerView.Adapter<MainAdapter.MainHolder>()  {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainAdapter.MainHolder {
        val binding = ItemProductBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return  MainHolder(binding)
    }

    override fun onBindViewHolder(holder: MainAdapter.MainHolder, position: Int) {
        holder.render(info.getJSONObject(position))
    }

    override fun getItemCount(): Int = info.length()


    class MainHolder(val binding: ItemProductBinding): RecyclerView.ViewHolder(binding.root){
        fun render(informacion: JSONObject){
            binding.tvName.setText(informacion.getString("title"))
            binding.tvPrecio.setText(informacion.getString("price"))
            binding.tvDescripcion.setText(informacion.getString("description"))
            binding.tvScore.setText(informacion.getString("rate"))
        }
    }
}