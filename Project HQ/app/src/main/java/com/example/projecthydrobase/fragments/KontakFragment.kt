package com.example.projecthydrobase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.projecthydrobase.databinding.FragmentKontakBinding
import com.example.projecthydrobase.fragments.adapters.KontakAdapter
import com.example.projecthydrobase.fragments.models.Kontak

class KontakFragment : Fragment() {
    private var _binding: FragmentKontakBinding? = null
    private val binding get() = _binding!!

    private val contacts = List(15) { i ->
        Kontak("Contact ${i+1}", "https://i.pravatar.cc/150?img=${i+10}", "+62 81${1000 + i}")
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentKontakBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.recyclerKontak.layoutManager = LinearLayoutManager(requireContext())
        binding.recyclerKontak.adapter = KontakAdapter(contacts)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
