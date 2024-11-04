package dev.airon.mytreasurybank.data.repository.auth

import com.google.firebase.database.FirebaseDatabase

class AuthFirebaseDataSourceImpl(firebaseDatabase: FirebaseDatabase) : AuthFirebaseDataSource {


    override suspend fun login(email: String, password: String) {
        TODO("Not yet implemented")
    }

    override suspend fun register(
        name: String,
        email: String,
        password: String,
        confirmPassword: String
    ) {
        TODO("Not yet implemented")
    }

    override suspend fun recoverAccount(email: String) {
        TODO("Not yet implemented")
    }
}