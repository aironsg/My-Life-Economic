package dev.airon.mytreasurybank.presenter.splash

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import dagger.hilt.android.AndroidEntryPoint
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentSplahBinding
import dev.airon.mytreasurybank.presenter.auth.login.LoginFragment

@AndroidEntryPoint
class SplashFragment : Fragment() {

    private var _binding: FragmentSplahBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSplahBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        getStarted()
    }

    private fun getStarted(){
        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_loginFragment)
        }, 2000)
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }


}