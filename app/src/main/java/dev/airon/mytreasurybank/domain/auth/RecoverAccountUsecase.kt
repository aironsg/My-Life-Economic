package dev.airon.mytreasurybank.domain.auth

import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RecoverAccountUsecase @Inject constructor (private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(email:String) {
        return authFirebaseDataSourceImpl.recoverAccount(email)
    }
}