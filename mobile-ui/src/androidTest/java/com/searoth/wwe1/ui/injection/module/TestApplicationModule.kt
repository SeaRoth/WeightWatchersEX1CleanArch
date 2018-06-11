package com.searoth.wwe1.ui.injection.module

import android.app.Application
import android.content.Context
import com.nhaarman.mockito_kotlin.mock
import dagger.Module
import dagger.Provides
import com.searoth.wwe1.cache.PreferencesHelper
import com.searoth.wwe1.data.executor.JobExecutor
import com.searoth.wwe1.data.repository.BufferooCache
import com.searoth.wwe1.data.repository.BufferooRemote
import com.searoth.wwe1.domain.executor.PostExecutionThread
import com.searoth.wwe1.domain.executor.ThreadExecutor
import com.searoth.wwe1.domain.repository.BufferooRepository
import com.searoth.wwe1.remote.BufferooService
import com.searoth.wwe1.ui.UiThread
import com.searoth.wwe1.ui.injection.scopes.PerApplication

@Module
class TestApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(): PreferencesHelper {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRepository(): BufferooRepository {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(): BufferooCache {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(): BufferooRemote {
        return mock()
    }

    @Provides
    @PerApplication
    internal fun provideThreadExecutor(jobExecutor: JobExecutor): ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @PerApplication
    internal fun providePostExecutionThread(uiThread: UiThread): PostExecutionThread {
        return uiThread
    }

    @Provides
    @PerApplication
    internal fun provideBufferooService(): BufferooService {
        return mock()
    }

}