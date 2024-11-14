package dev.airon.mytreasurybank.presenter.auth.recover

import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.AccelerateInterpolator
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentResetAccountBinding
import dev.airon.mytreasurybank.util.StateView
import dev.airon.mytreasurybank.util.initToolbar
import dev.airon.mytreasurybank.util.isEmailValid
import dev.airon.mytreasurybank.util.showBottomSheet

@AndroidEntryPoint
class ResetAccountFragment : Fragment() {

    private var _binding: FragmentResetAccountBinding? = null
    private val binding get() = _binding!!
    private val resetAccountViewModel: ResetAccountViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentResetAccountBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }


    private fun initListener() {
        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_resetAccountFragment_to_registerFragment)
        }
        binding.btnResetPassword.setOnClickListener {
            validateData()

        }
    }

    private fun sendMail(email: String) {
        binding.flyingMailIcon.visibility = View.VISIBLE
        val translationY = -binding.btnResetPassword.y - binding.btnResetPassword.height * 2

        binding.flyingMailIcon
            .animate()
            .translationY(translationY)
            .scaleX(0.5f)  // Reduz a escala no eixo X
            .scaleY(0.5f)  // Reduz a escala no eixo Y
            .alpha(0f)     // Desaparece gradualmente
            .setInterpolator(AccelerateInterpolator()) // Efeito de aceleração
            .setDuration(2500) // Duração mais longa para suavidade
            .withEndAction {
                binding.flyingMailIcon.visibility = View.INVISIBLE
                binding.flyingMailIcon.alpha = 1f // Restaura opacidade
                binding.flyingMailIcon.scaleX = 1f // Restaura escala
                binding.flyingMailIcon.scaleY = 1f
                binding.flyingMailIcon.translationY = 0f // Restaura posição
            }
            .start()
    }


    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()
        if (email.isNotEmpty()) {
            if (isEmailValid(email)) {

                resetAccount(email)
            } else {
                showBottomSheet(getString(R.string.txt_email_invalid))

            }
        } else {
            showBottomSheet(getString(R.string.txt_email_is_empty))
        }
    }

    private fun resetAccount(email: String) {
        resetAccountViewModel.resetAccount(email).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }

                is StateView.Success -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    showBottomSheet("Você está prestes a enviar um E-mail para : $email ",
                        titleButton = R.string.txt_button_bottomSheet_confirm,
                        onClick = {
                            sendMail(email)
                            Handler(Looper.getMainLooper()).postDelayed({
                                findNavController().navigate(R.id.action_resetAccountFragment_to_checkEmailFragment)
                            }, 3000)
                        })
                }

                is StateView.Error -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    Toast.makeText(requireContext(), stateView.message, Toast.LENGTH_SHORT).show()
                }
            }
        }
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}