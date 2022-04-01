package com.example.obbliapp.di


import com.example.obbliapp.data.dataSources.MoveDataSources
import com.example.obbliapp.data.repository.MoveRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent


@InstallIn(ViewModelComponent::class)
@Module
abstract class MoveModule() {

    @Binds
    abstract fun bindMoveModule(impl : MoveDataSources) : MoveRepository
}