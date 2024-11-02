package dev.airon.mytreasurybank.presenter.auth

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentCreateAccountBinding
import dev.airon.mytreasurybank.databinding.FragmentResetAccountBinding

class ResetAccountFragment : Fragment() {

    private var _binding: FragmentResetAccountBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View {
        _binding = FragmentResetAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}