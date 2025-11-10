package com.android.moviemaniaa.ui.series

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.android.moviemaniaa.databinding.FragmentSeriesBinding

class SeriesFragment : Fragment() {

    private var _binding: FragmentSeriesBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSeriesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        binding.tvTitle.text = "Series Screen"
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
