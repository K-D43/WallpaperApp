package com.example.wallpaper.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.wallpaper.Model.bestofmonthModel
import com.example.wallpaper.R

class bomAdapter(val requireContext: Context,val listBestOfMonth: ArrayList<bestofmonthModel>) :RecyclerView.Adapter<bomAdapter.bomViewHolder>() {
    inner class bomViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val imageView=itemView.findViewById<ImageView>(R.id.bom_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): bomViewHolder {
        return bomViewHolder(
            LayoutInflater.from(requireContext).inflate(R.layout.item_bom,parent,false)
        )
    }

    override fun onBindViewHolder(holder: bomViewHolder, position: Int) {
        holder.imageView

        Glide.with(requireContext).load(listBestOfMonth[position].link).into(holder.imageView)
    }

    override fun getItemCount(): Int {
        return listBestOfMonth.size
    }
}