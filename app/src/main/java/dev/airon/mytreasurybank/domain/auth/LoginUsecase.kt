package dev.airon.mytreasurybank.domain.auth

import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl

class LoginUsecase(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(email: String, password: String) {

        return authFirebaseDataSourceImpl.login(email, password)
    }

}