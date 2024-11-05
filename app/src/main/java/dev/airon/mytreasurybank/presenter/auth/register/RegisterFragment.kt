package dev.airon.mytreasurybank.presenter.auth.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentRegisterBinding
import dev.airon.mytreasurybank.databinding.FragmentRegisterBinding.*
import dev.airon.mytreasurybank.ui.initToolbar

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!

    @SuppressLint("SuspiciousIndentation")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }

    private fun initListener() {

        binding.btnSignUp.setOnClickListener {

            validateData()
        }

        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_registerFragment_to_loginFragment)
        }
    }

    private fun validateData() {
        val name = binding.edtName.text.toString().trim()
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()
        val confirmPassword = binding.edtPasswordConfirm.text.toString().trim()

        if (name.isNotEmpty()) {
            if (email.isNotEmpty()) {
                if (password.isNotEmpty()) {
                    if (confirmPassword.isNotEmpty() && password == confirmPassword) {
                        Toast.makeText(requireContext(), "campos validados", Toast.LENGTH_SHORT)
                            .show()
                    } else {
                        Toast.makeText(requireContext(), "senhas não conferem", Toast.LENGTH_SHORT)
                            .show()
                    }
                } else {
                    Toast.makeText(requireContext(), "preencha sua senha", Toast.LENGTH_SHORT)
                        .show()
                }
            } else {
                Toast.makeText(requireContext(), "preencha seu e-mail", Toast.LENGTH_SHORT).show()
            }
        } else {
            Toast.makeText(requireContext(), "preencha seu nome", Toast.LENGTH_SHORT).show()

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


}