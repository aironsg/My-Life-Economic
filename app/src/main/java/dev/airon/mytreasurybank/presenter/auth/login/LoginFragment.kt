package dev.airon.mytreasurybank.presenter.auth.login

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import dev.airon.mytreasurybank.databinding.FragmentLoginBinding


class LoginFragment : Fragment() {

    final var _binding: FragmentLoginBinding? = null
    final val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentLoginBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initListener()
    }

    private fun initListener(){
        binding.btnSignIn.setOnClickListener {
            validateData()
        }
    }

    private fun validateData(){
        val email = binding.edtEmail.text.toString().trim()
        val password = binding.edtPassword.text.toString().trim()

        if(email.isNotEmpty()){
            if(password.isNotEmpty()){
                Toast.makeText(requireContext(), "campos validados", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(requireContext(), "preencha seu e-mail", Toast.LENGTH_SHORT).show()
            }
        }else{
            Toast.makeText(requireContext(), "preencha seu e-mail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}