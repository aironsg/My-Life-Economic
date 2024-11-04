package dev.airon.mytreasurybank.domain.auth

import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl

class RecoverAccountUsecase(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(email:String) {
        return authFirebaseDataSourceImpl.recoverAccount(email)
    }
}