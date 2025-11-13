package com.example.projecthydrobase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.projecthydrobase.databinding.FragmentKalkulatorBinding
import kotlin.math.sqrt

class KalkulatorFragment : Fragment() {
    private var _binding: FragmentKalkulatorBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentKalkulatorBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        fun getVal(): Double {
            val s = binding.etInput.text.toString()
            return s.toDoubleOrNull() ?: 0.0
        }

        binding.btnAdd.setOnClickListener {
            val v = getVal()
            binding.tvResult.text = (v + v).toString()
        }
        binding.btnSub.setOnClickListener {
            val v = getVal()
            binding.tvResult.text = (v - v).toString()
        }
        binding.btnMul.setOnClickListener {
            val v = getVal()
            binding.tvResult.text = (v * v).toString()
        }
        binding.btnDiv.setOnClickListener {
            val v = getVal()
            binding.tvResult.text = if (v==0.0) "NaN" else (v / v).toString()
        }
        binding.btnSqrt.setOnClickListener {
            val v = getVal()
            binding.tvResult.text = sqrt(v).toString()
        }
        binding.btnSquare.setOnClickListener {
            val v = getVal()
            binding.tvResult.text = (v * v).toString()
        }
        binding.btnClear.setOnClickListener {
            binding.etInput.setText("")
            binding.tvResult.text = ""
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
