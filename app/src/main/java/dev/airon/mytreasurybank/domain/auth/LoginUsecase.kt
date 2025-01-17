package dev.airon.mytreasurybank.domain.auth

import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class LoginUsecase @Inject constructor(private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(email: String, password: String) {

        return authFirebaseDataSourceImpl.login(email, password)
    }

}