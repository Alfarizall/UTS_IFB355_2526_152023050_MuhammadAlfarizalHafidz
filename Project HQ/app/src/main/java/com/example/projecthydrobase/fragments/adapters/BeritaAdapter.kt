package com.example.projecthydrobase.fragments.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.projecthydrobase.databinding.ItemBeritaBinding
import com.example.projecthydrobase.fragments.models.Berita

class BeritaAdapter(private val items: List<Berita>) : RecyclerView.Adapter<BeritaAdapter.VH>() {
    class VH(val binding: ItemBeritaBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        val b = ItemBeritaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return VH(b)
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        val item = items[position]
        holder.binding.tvTitle.text = item.title
        holder.binding.tvSummary.text = item.summary
        holder.binding.ivNews.load(item.imageUrl) { crossfade(true) }
    }

    override fun getItemCount(): Int = items.size
}
