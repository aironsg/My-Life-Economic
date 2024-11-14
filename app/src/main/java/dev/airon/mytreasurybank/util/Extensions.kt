@file:Suppress("DEPRECATION")

package dev.airon.mytreasurybank.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Rect
import android.os.Handler
import android.os.Looper
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.core.content.ContextCompat
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.google.android.material.bottomsheet.BottomSheetDialog
import com.google.android.material.snackbar.Snackbar
import dev.airon.mytreasurybank.R
import dev.airon.mytreasurybank.databinding.CustomBottomSheetBinding

fun Fragment.initToolbar(toolbar: Toolbar, homeAsUpEnabled: Boolean = true) {
    (activity as AppCompatActivity).setSupportActionBar(toolbar)
    (activity as AppCompatActivity).title = ""
    (activity as AppCompatActivity).supportActionBar?.setHomeAsUpIndicator(R.drawable.ic_arrow_left_s_line)
    (activity as AppCompatActivity).supportActionBar?.setDisplayHomeAsUpEnabled(homeAsUpEnabled)
    toolbar.setNavigationOnClickListener {
        activity?.onBackPressed()
    }
}

fun isEmailValid(email: String): Boolean {
    val emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    return email.matches(emailPattern.toRegex())
}

fun isPasswordValid(password: String): Boolean {
    val passwordPattern = "^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[@#$%^&+=])(?=\\S+$).{8,}$"
    return password.matches(passwordPattern.toRegex())
}

fun Fragment.showBottomSheet(
    message: String,
    titleButton: Int? = null,
    onClick: () -> Unit = {}
) {

    val bottomSheetDialog = BottomSheetDialog(requireContext(), R.style.BottomSheetDialog)
    val bottomSheetBinding: CustomBottomSheetBinding =
        CustomBottomSheetBinding.inflate(layoutInflater, null, false)

    bottomSheetBinding.message.text = message
    bottomSheetBinding.btnOk.text = getString(titleButton ?: R.string.txt_button_bottomSheet_ok)
    bottomSheetBinding.btnOk.setOnClickListener {
        onClick()
        bottomSheetDialog.dismiss()
    }
    bottomSheetDialog.setContentView(bottomSheetBinding.root)
    bottomSheetDialog.show()


}


// Extension function para aplicar a máscara de telefone
fun EditText.addPhoneMask() {
    this.addTextChangedListener(object : TextWatcher {
        private var isUpdating = false

        override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

        override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
            if (isUpdating) return
            isUpdating = true

            // Remove caracteres especiais
            var phone = s.toString().replace("[^\\d]".toRegex(), "")

            // Aplica a máscara: (##) #####-####
            if (phone.length > 11) phone = phone.substring(0, 11)
            val formatted = when (phone.length) {
                in 1..2 -> "($phone"
                in 3..7 -> "(${phone.substring(0, 2)}) ${phone.substring(2)}"
                in 8..11 -> "(${phone.substring(0, 2)}) ${
                    phone.substring(
                        2,
                        7
                    )
                }-${phone.substring(7)}"

                else -> phone
            }

            setText(formatted)
            setSelection(formatted.length)
            isUpdating = false
        }

        override fun afterTextChanged(s: Editable?) {}
    })
}


