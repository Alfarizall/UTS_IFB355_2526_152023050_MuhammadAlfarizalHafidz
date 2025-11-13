package com.example.projecthydrobase.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import coil.load
import com.example.projecthydrobase.R
import com.example.projecthydrobase.databinding.FragmentCuacaBinding

class CuacaFragment : Fragment() {
    private var _binding: FragmentCuacaBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCuacaBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // Data cuaca statis
        val iconUrl = "https://openweathermap.org/img/wn/10d@2x.png"

        // Load ikon cuaca dengan efek crossfade
        binding.ivWeather.load(iconUrl) {
            crossfade(true)
            placeholder(R.drawable.ic_weather_placeholder)
        }

        // Isi data cuaca statis
        binding.tvLocation.text = getString(R.string.weather_location)
        binding.tvTemp.text = getString(R.string.weather_temp)
        binding.tvCondition.text = getString(R.string.weather_condition)
        binding.tvHumidity.text = getString(R.string.weather_humidity)
        binding.tvWind.text = getString(R.string.weather_wind)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
