package com.example.projecthydrobase.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.projecthydrobase.databinding.ItemKontakBinding
import com.example.projecthydrobase.fragments.models.Kontak

class KontakAdapter(private val items: List<Kontak>) : RecyclerView.Adapter<KontakAdapter.VH>() {
    class VH(val binding: ItemKontakBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemKontakBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.binding.tvName.text = item.name
        holder.binding.tvPhone.text = item.phone
        holder.binding.ivAvatar.load(item.avatarUrl) {
            crossfade(true)
        }
    }

    override fun getItemCount(): Int = items.size
}
