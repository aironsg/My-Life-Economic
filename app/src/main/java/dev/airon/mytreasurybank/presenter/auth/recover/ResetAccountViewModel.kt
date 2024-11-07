package dev.airon.mytreasurybank.presenter.auth.recover

import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import dagger.hilt.android.lifecycle.HiltViewModel
import dev.airon.mytreasurybank.domain.auth.RecoverAccountUsecase
import dev.airon.mytreasurybank.util.StateView
import kotlinx.coroutines.Dispatchers
import javax.inject.Inject

@HiltViewModel
class ResetAccountViewModel @Inject constructor(private val resetAccountUsecase: RecoverAccountUsecase) :
    ViewModel() {

    fun resetAccount(email: String) = liveData(Dispatchers.IO) {
        try {
            emit(StateView.Loading())
            resetAccountUsecase.invoke(email)
            emit(StateView.Success(null))

        } catch (ex: Exception) {
            emit(StateView.Error(ex.message))
        }
    }
}