package com.example.obbliapp.di


import com.example.obbliapp.data.domain.HomeImplement
import com.example.obbliapp.data.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
abstract class HomeModule() {

    @Binds
    abstract fun bindHomeModule(impl : HomeImplement) : HomeRepository
}