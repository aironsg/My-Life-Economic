package dev.airon.mytreasurybank.domain.auth

import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl

class RegisterUsecase(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(name:String,email:String, password:String, confirmPassword:String) {

        return authFirebaseDataSourceImpl.register(name,email, password, confirmPassword)
    }

}