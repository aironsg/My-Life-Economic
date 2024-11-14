package dev.airon.mytreasurybank.presenter.wallet

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentRegisterBinding
import dev.airon.mytreasurybank.databinding.FragmentRegisterBinding.inflate
import dev.airon.mytreasurybank.databinding.FragmentWalletBinding
import dev.airon.mytreasurybank.presenter.auth.register.RegisterViewModel
import dev.airon.mytreasurybank.util.addPhoneMask
import dev.airon.mytreasurybank.util.initToolbar


class WalletFragment : Fragment() {


    private var _binding: FragmentWalletBinding? = null
    private val binding get() = _binding!!
    private val registerViewModel: RegisterViewModel by viewModels()

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentWalletBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar, iconColor = R.color.white)



    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null

    }
}