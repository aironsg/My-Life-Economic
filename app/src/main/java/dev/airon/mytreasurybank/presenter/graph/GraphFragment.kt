package dev.airon.mytreasurybank.presenter.graph

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentGraphBinding
import dev.airon.mytreasurybank.databinding.FragmentTransactionBinding


class GraphFragment : Fragment() {
    private var _binding: FragmentGraphBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentGraphBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}