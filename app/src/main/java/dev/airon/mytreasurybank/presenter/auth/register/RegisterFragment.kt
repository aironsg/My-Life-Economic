package dev.airon.mytreasurybank.presenter.auth.register

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.data.model.User
import dev.airon.mytreasurybank.databinding.FragmentRegisterBinding
import dev.airon.mytreasurybank.databinding.FragmentRegisterBinding.*
import dev.airon.mytreasurybank.util.StateView
import dev.airon.mytreasurybank.util.initToolbar
import dev.airon.mytreasurybank.util.isEmailValid
import dev.airon.mytreasurybank.util.isPasswordValid
import dev.airon.mytreasurybank.util.showBottomSheet

@AndroidEntryPoint
class RegisterFragment : Fragment() {
    private var _binding: FragmentRegisterBinding? = null
    private val binding get() = _binding!!
    private val registerViewModel: RegisterViewModel by viewModels()

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
        val phoneNumber = binding.edtPhoneNumber.text.toString().trim()

        //validação nome
        if (name.isEmpty()) {
            showBottomSheet(getString(R.string.txt_name_is_empty))
            return
        }

        //validação email
        if (email.isEmpty()) {
            showBottomSheet(getString(R.string.txt_email_is_empty))
            if (!isEmailValid(email)) {
                showBottomSheet(getString(R.string.txt_email_invalid))
                return
            }
            return
        }
        //validação de telefone
        if (phoneNumber.isEmpty()) {
            showBottomSheet(getString(R.string.txt_phone_number_is_empty))
            return
        }

        //validação senha
        if (password.isEmpty()) {
            showBottomSheet(getString(R.string.txt_password_is_empty))
            if (!isPasswordValid(password)) {
                showBottomSheet(getString(R.string.txt_password_security))
                return
            }
            return
        }


        val user = User(name = name, email = email,phoneNumber = phoneNumber , password = password)
        registerUser(user)
    }

    private fun registerUser(user: User) {

        registerViewModel.register(user).observe(viewLifecycleOwner) { stateView ->
            when (stateView) {
                is StateView.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }


                is StateView.Success -> {

                    binding.progressCircular.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(),
                        "Usuário cadastro com sucesso!",
                        Toast.LENGTH_SHORT
                    )
                        .show()
                    findNavController().navigate(R.id.action_global_homeFragment)
                    Toast.makeText(requireContext(), "Bem-Vindo", Toast.LENGTH_SHORT).show()

                }

                is StateView.Error -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    Toast.makeText(
                        requireContext(),
                        stateView.message,
                        Toast.LENGTH_SHORT
                    )
                        .show()

                }
            }
        }


    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null

    }


}