package dev.airon.mytreasurybank.presenter.auth.register

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.airon.mytreasurybank.data.model.User
import dev.airon.mytreasurybank.domain.auth.RegisterUsecase
import dev.airon.mytreasurybank.util.StateView
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
 class RegisterViewModel @Inject constructor(
    private val registerUsecase: RegisterUsecase

) : ViewModel() {
    fun register(user: User) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            registerUsecase.invoke(user)
            emit(StateView.Success(user))

        } catch (ex: Exception) {
            emit(StateView.Error(ex.message))
        }
    }
}