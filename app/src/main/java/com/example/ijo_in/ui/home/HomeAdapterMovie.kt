package com.example.ijo_in.ui.home

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ijo_in.R
import com.example.ijo_in.data.remote.response.movie.Result

class HomeAdapterMovie(private val listMovie : List<Result>):RecyclerView.Adapter<HomeAdapterMovie.MyViewHolder>() {

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.title_rv)
        val tvImg: ImageView = itemView.findViewById(R.id.rv_card_img)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapterMovie.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapterMovie.MyViewHolder, position: Int) {
        holder.tvTitle.text = listMovie[position].title
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500${listMovie[position].posterPath}")
            .into(holder.tvImg)
    }

    override fun getItemCount(): Int {
        return listMovie.size
    }

}