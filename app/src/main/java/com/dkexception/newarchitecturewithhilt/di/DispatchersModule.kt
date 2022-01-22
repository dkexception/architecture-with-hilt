package com.dkexception.newarchitecturewithhilt.di

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
class DispatchersModule {

    @Provides
    @Singleton
    fun provideStandardDispatchers(): StandardDispatchers = object : StandardDispatchers {
        override val ioDispatcher: CoroutineDispatcher
            get() = Dispatchers.IO
        override val defaultDispatcher: CoroutineDispatcher
            get() = Dispatchers.Default
        override val mainDispatcher: CoroutineDispatcher
            get() = Dispatchers.Main
        override val unconfinedDispatcher: CoroutineDispatcher
            get() = Dispatchers.Unconfined
    }
}

interface StandardDispatchers {
    val ioDispatcher: CoroutineDispatcher
    val defaultDispatcher: CoroutineDispatcher
    val mainDispatcher: CoroutineDispatcher
    val unconfinedDispatcher: CoroutineDispatcher
}
