package dev.airon.mytreasurybank.data.repository.auth

import com.google.firebase.auth.FirebaseUser
import dev.airon.mytreasurybank.data.model.User

interface AuthFirebaseDataSource {

    suspend fun login(email:String, password:String)
    suspend fun register(user: User) : User
    suspend fun recoverAccount(email:String)
}