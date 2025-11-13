package com.example.projecthydrobase.fragments

import android.app.DatePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.fragment.app.Fragment
import com.example.projecthydrobase.databinding.FragmentBiodataBinding
import java.util.Calendar

class BiodataFragment : Fragment() {
    private var _binding: FragmentBiodataBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentBiodataBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Spinner (dropdown)
        val items = listOf("Pilih pendidikan", "SMA", "D3", "S1", "S2")
        binding.spinnerPendidikan.adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_dropdown_item, items)

        binding.btnTanggal.setOnClickListener {
            val c = Calendar.getInstance()
            val dp = DatePickerDialog(requireContext(), { _, y, m, d ->
                binding.tvTanggal.text = "$d/${m+1}/$y"
            }, c.get(Calendar.YEAR), c.get(Calendar.MONTH), c.get(Calendar.DAY_OF_MONTH))
            dp.show()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
