package com.example.ijo_in.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ijo_in.R
import com.example.ijo_in.data.remote.response.plants.Data

class HomeAdapterPlants(private val listPlants: List<Data>): RecyclerView.Adapter<HomeAdapterPlants.ViewHolder>() {

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.title_rv)
        val tvImg: ImageView = itemView.findViewById(R.id.rv_card_img)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterPlants.ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.tvTitle.text = listPlants[position].commonName
        Glide.with(holder.itemView.context)
            .load(listPlants[position].imageUrl)
            .into(holder.tvImg)
    }


    override fun getItemCount(): Int = listPlants.size

}