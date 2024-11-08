package dev.airon.mytreasurybank.domain.auth

import dev.airon.mytreasurybank.data.model.User
import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl
import javax.inject.Inject

class RegisterUsecase @Inject constructor (private val authFirebaseDataSourceImpl: AuthFirebaseDataSourceImpl) {

    suspend operator fun invoke(user: User) : User {

        return authFirebaseDataSourceImpl.register(user)
    }

}