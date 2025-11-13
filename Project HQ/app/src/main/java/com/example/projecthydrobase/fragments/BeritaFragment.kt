package com.example.projecthydrobase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecthydrobase.databinding.FragmentBeritaBinding
import com.example.projecthydrobase.fragments.adapters.BeritaAdapter
import com.example.projecthydrobase.fragments.models.Berita

class BeritaFragment : Fragment() {
    private var _binding: FragmentBeritaBinding? = null
    private val binding get() = _binding!!

    private val news = List(8) { i ->
        Berita("Judul Berita ${i+1}", "Ringkasan singkat berita nomor ${i+1}", "https://picsum.photos/300/200?random=${i+5}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBeritaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerBerita.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerBerita.adapter = BeritaAdapter(news)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
