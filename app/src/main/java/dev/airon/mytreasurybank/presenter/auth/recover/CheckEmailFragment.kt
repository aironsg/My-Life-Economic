package dev.airon.mytreasurybank.presenter.auth.recover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentCheckEmailBinding

@AndroidEntryPoint
class CheckEmailFragment : Fragment() {

    private var _binding: FragmentCheckEmailBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentCheckEmailBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()

    }

    private fun initListener() {
        binding.btnCheckEmail.setOnClickListener {
            //logica para enviar email de verificação
            //ao clicar no botão o usuario será direcionado para a tela de login
        }

    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}