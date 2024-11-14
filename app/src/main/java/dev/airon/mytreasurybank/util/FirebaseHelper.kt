package dev.airon.mytreasurybank.util

import com.google.firebase.auth.FirebaseAuth
import dev.airon.mytreasurybank.R

class FirebaseHelper {

    companion object {
        fun isAuthenticated() = FirebaseAuth.getInstance().currentUser != null


        fun validError(error: String): Int {
            return when {
                error.contains("The supplied auth credential is incorrect, malformed or has expired.") -> {
                    R.string.account_not_registered
                }

                error.contains("The email address is badly formatted.") -> {
                    R.string.invalid_email
                }

                error.contains("The password is invalid or the user does not have a password.") -> {
                    R.string.invalid_password
                }

                error.contains("The email address is already in use by another account.") -> {
                    R.string.email_in_use
                }

                else -> R.string.txt_error_unknow
            }
        }
    }
}