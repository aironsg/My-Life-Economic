package dev.airon.mytreasurybank.di

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSource
import dev.airon.mytreasurybank.data.repository.auth.AuthFirebaseDataSourceImpl

@Module
@InstallIn(ViewModelComponent::class)
abstract class DomainModule {

    @Binds
    abstract fun bindAuthRepository(firebaseDataSourceImpl: AuthFirebaseDataSourceImpl):
            AuthFirebaseDataSource
}