package com.Sutabah.JenisJenisHewan.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.Sutabah.JenisJenisHewan.databinding.ListItemHewanBinding
import com.Sutabah.JenisJenisHewan.model.Hewan

class AdapterJenisHewan(private val context: Context,
                        private var data : List<Hewan>?,
        private val itemclick : OnclickListener)
    : RecyclerView.Adapter<AdapterJenisHewan.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ListItemHewanBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = data?.get(position)
        holder.foto.setImageResource(item?.foto ?:0)
        holder.nama.text = item?.nama

        holder.itemView.setOnClickListener {
            itemclick.detailData(item)
        }
    }

    override fun getItemCount(): Int = data?.size ?:0


    inner class ViewHolder ( val binding: ListItemHewanBinding): RecyclerView.ViewHolder(binding.root) {
    var foto = binding.image
    var nama = binding.txtnama

    }

    interface OnclickListener {
        fun detailData(item: Hewan?)

    }

}