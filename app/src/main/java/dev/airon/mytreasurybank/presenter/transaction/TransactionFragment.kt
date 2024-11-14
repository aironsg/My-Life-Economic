package dev.airon.mytreasurybank.presenter.transaction

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import androidx.core.content.ContextCompat
import androidx.fragment.app.FragmentTransaction
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.FragmentHomeBinding
import dev.airon.mytreasurybank.databinding.FragmentTransactionBinding


class TransactionFragment : Fragment() {
    private var _binding: FragmentTransactionBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentTransactionBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

    }


    private fun validateFields() {

        
    }



    private fun selectTypeTransaction() {
//        criar logica para transferir tipo para a criação da transação
        binding.toggleGroup.addOnButtonCheckedListener{ _, checkedId, isChecked ->
            if (isChecked) {
                when (checkedId) {
                    binding.btnIncome.id -> {
                        binding.btnIncome.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.color_selected)
                        binding.btnExpenses.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.color_unselected)
                    }
                    binding.btnExpenses.id -> {
                        binding.btnIncome.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.color_unselected)
                        binding.btnExpenses.backgroundTintList = ContextCompat.getColorStateList(requireContext(), R.color.color_selected)
                    }
                }

            }
        }
    }

    private fun selectCategory() {
        val option = listOf<String>("compras da casa", "lazer", "alimentação", "saúde", "outros")
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, option)
        binding.selectCategory.setAdapter(adapter)

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}