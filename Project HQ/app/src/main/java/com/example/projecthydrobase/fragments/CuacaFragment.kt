package com.example.projecthydrobase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.projecthydrobase.databinding.FragmentCuacaBinding

class CuacaFragment : Fragment() {
    private var _binding: FragmentCuacaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        _binding = FragmentCuacaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        // Static weather data, images from online
        val iconUrl = "https://openweathermap.org/img/wn/10d@2x.png"
        binding.ivWeather.load(iconUrl)
        binding.tvTemp.text = "28°C"
        binding.tvHumidity.text = "Kelembapan: 78%"
        binding.tvCondition.text = "Hujan ringan"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
