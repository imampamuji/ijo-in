package com.example.ijo_in.ui.home

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.ijo_in.R
import com.example.ijo_in.data.remote.response.Data
import com.example.ijo_in.data.remote.response.movie.MovieResponse
import com.example.ijo_in.data.remote.response.movie.Result

class HomeAdapter(private val list : List<Result>):RecyclerView.Adapter<HomeAdapter.MyViewHolder>() {

    inner class MyViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        val tvTitle: TextView = itemView.findViewById(R.id.title_rv)
        val tvImg: ImageView = itemView.findViewById(R.id.rv_card_img)
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HomeAdapter.MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_plant, parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: HomeAdapter.MyViewHolder, position: Int) {
        holder.tvTitle.text = list[position].title
        Glide.with(holder.itemView.context)
            .load("https://image.tmdb.org/t/p/w500${list[position].posterPath}")
            .into(holder.tvImg)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}