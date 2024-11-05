package dev.airon.mytreasurybank.data.repository.auth

import com.google.firebase.auth.FirebaseUser

interface AuthFirebaseDataSource {

    suspend fun login(email:String, password:String)
    suspend fun register(name:String,email:String, password:String, confirmPassword:String) : FirebaseUser
    suspend fun recoverAccount(email:String)
}