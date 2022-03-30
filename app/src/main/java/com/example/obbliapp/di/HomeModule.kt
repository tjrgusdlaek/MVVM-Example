package com.example.obbliapp.di


import androidx.fragment.app.Fragment
import com.example.obbliapp.data.domain.HomeImplement
import com.example.obbliapp.data.repository.HomeRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.android.scopes.FragmentScoped


@InstallIn(FragmentComponent::class)
@Module
abstract class HomeModule(@ApplicationContext context: Fragment) {

    @FragmentScoped
    @Binds
    abstract fun bindHomeModule(impl : HomeImplement) : HomeRepository
}