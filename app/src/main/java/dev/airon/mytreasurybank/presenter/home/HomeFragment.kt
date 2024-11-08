@file:Suppress("DEPRECATION")

package dev.airon.mytreasurybank.presenter.home

import android.content.res.ColorStateList
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.R.color.color_default
import dev.airon.mytreasurybank.data.model.Transaction
import dev.airon.mytreasurybank.databinding.FragmentHomeBinding

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setupColors()
    }


    private fun setupColors() {
        requireActivity().window.statusBarColor =
            ContextCompat.getColor(requireContext(), R.color.color_status_bar_home)
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }




}