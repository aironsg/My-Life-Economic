package dev.airon.mytreasurybank.presenter.auth.recover

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.databinding.FragmentResetAccountBinding
import dev.airon.mytreasurybank.ui.initToolbar

@AndroidEntryPoint
class ResetAccountFragment : Fragment() {

    private var _binding: FragmentResetAccountBinding? = null
    private val binding get() = _binding!!

    //TODO: implementar logica que defina a mensagem para o usuario.

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ):  View {
        _binding = FragmentResetAccountBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initToolbar(binding.toolbar)
        initListener()
    }



    private fun initListener(){
        binding.btnResetPassword.setOnClickListener {
            ValidateData()
        }
    }

    private fun ValidateData(){
        val email = binding.edtEmail.text.toString().trim()
        if(email.isNotEmpty()){
            Toast.makeText(requireContext(), "campos validados", Toast.LENGTH_SHORT).show()
        }else{
            Toast.makeText(requireContext(), "preencha seu e-mail", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }

}