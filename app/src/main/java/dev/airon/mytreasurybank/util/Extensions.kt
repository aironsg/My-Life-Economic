@file:Suppress("DEPRECATION")

package dev.airon.mytreasurybank.util

import android.annotation.SuppressLint
import android.graphics.Color
import android.graphics.Rect
import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
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
    bottomSheetBinding.btnOk.text = getString(titleButton?: R.string.txt_button_bottomSheet_ok)
    bottomSheetBinding.btnOk.setOnClickListener { onClick()
    bottomSheetDialog.dismiss()}
    bottomSheetDialog.setContentView(bottomSheetBinding.root)
    bottomSheetDialog.show()


}

//@SuppressLint("ClickableViewAccessibility")
//private fun showSnackBar(email: String) {
//    val snackbar = Snackbar.make(binding.root, "Você está prestes a enviar um E-mail para : $email ", Snackbar.LENGTH_INDEFINITE)
//        .setAction("Confirmar") {
//            sendMail(email)
//            Handler(Looper.getMainLooper()).postDelayed({
//                findNavController().navigate(R.id.action_resetAccountFragment_to_checkEmailFragment)
//            }, 3000)
//        }.setTextColor(ContextCompat.getColor(requireContext(), R.color.txt_color_snackbar))
//        .setActionTextColor(ContextCompat.getColor(requireContext(), R.color.button_confirm_color_snackbar))
//        .setBackgroundTint(ContextCompat.getColor(requireContext(), R.color.background_color_snackbar))
//
//    snackbar.show()
//
//    binding.root.setOnTouchListener { _, event ->
//        if (event.action == MotionEvent.ACTION_DOWN) {
//            val snackbarView = snackbar.view
//            val rect = Rect()
//            snackbarView.getGlobalVisibleRect(rect)
//
//            if (!rect.contains(event.rawX.toInt(), event.rawY.toInt())) {
//                snackbar.dismiss()
//                binding.root.setOnTouchListener(null)
//            }
//        }
//        false
//    }
//}


