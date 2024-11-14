package dev.airon.mytreasurybank.presenter.auth.login

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentLoginBinding
import dev.airon.mytreasurybank.util.StateView
import dev.airon.mytreasurybank.util.isEmailValid
import dev.airon.mytreasurybank.util.showBottomSheet

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private  var _binding: FragmentLoginBinding? = null
    private  val binding get() = _binding!!
    private val loginViewModel: LoginViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener() {
        binding.btnSignIn.setOnClickListener {
            validateData()
        }
        binding.btnForgotPassword.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_resetAccountFragment)
        }

        binding.btnCreateAccount.setOnClickListener {
            findNavController().navigate(R.id.action_loginFragment_to_registerFragment)
        }
    }

    private fun validateData() {
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if (email.isNotEmpty()) {
            if (isEmailValid(email)) {
                if (password.isNotEmpty()) {
                   loginUser(email, password)
                } else {
                    showBottomSheet(getString(R.string.txt_password_is_empty))
                }
            } else {
                showBottomSheet(getString(R.string.txt_email_invalid))
            }
        } else {
            showBottomSheet(getString(R.string.txt_email_is_empty))
        }
    }

    private fun loginUser(email:String, password:String){
        loginViewModel.login(email,password).observe(viewLifecycleOwner){stateView ->
            when(stateView){
                is StateView.Loading -> {
                    binding.progressCircular.visibility = View.VISIBLE
                }
                is StateView.Success ->{
                    binding.progressCircular.visibility = View.INVISIBLE
                    findNavController().navigate(R.id.action_global_homeFragment)
                    Toast.makeText(requireContext(),"Bem-Vindo",Toast.LENGTH_SHORT).show()
                }

                is StateView.Error -> {
                    binding.progressCircular.visibility = View.INVISIBLE
                    Log.i("INFOTEST", "loginUser: ")
                    Toast.makeText(requireContext(),stateView.message,Toast.LENGTH_SHORT).show()
                }

            }

        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}