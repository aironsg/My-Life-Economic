package dev.airon.mytreasurybank.data.repository.auth

interface AuthFirebaseDataSource {

    suspend fun login(email:String, password:String)
    suspend fun register(name:String,email:String, password:String, confirmPassword:String)
    suspend fun recoverAccount(email:String)
}