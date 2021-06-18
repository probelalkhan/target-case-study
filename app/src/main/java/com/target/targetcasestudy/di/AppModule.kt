package com.target.targetcasestudy.di

import com.target.targetcasestudy.data.network.RemoteDataSource
import com.target.targetcasestudy.data.network.TargetApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideTargetApi(
        remoteDataSource: RemoteDataSource
    ): TargetApi {
        return remoteDataSource.buildApi(TargetApi::class.java)
    }
}