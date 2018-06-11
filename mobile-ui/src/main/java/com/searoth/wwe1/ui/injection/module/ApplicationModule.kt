package com.searoth.wwe1.ui.injection.module

import android.app.Application
import android.content.Context
import dagger.Module
import dagger.Provides
import com.searoth.wwe1.cache.BufferooCacheImpl
import com.searoth.wwe1.cache.PreferencesHelper
import com.searoth.wwe1.cache.db.DbOpenHelper
import com.searoth.wwe1.cache.mapper.BufferooEntityMapper
import com.searoth.wwe1.data.BufferooDataRepository
import com.searoth.wwe1.data.executor.JobExecutor
import com.searoth.wwe1.data.mapper.BufferooMapper
import com.searoth.wwe1.data.repository.BufferooCache
import com.searoth.wwe1.data.repository.BufferooRemote
import com.searoth.wwe1.data.source.BufferooDataStoreFactory
import com.searoth.wwe1.domain.executor.PostExecutionThread
import com.searoth.wwe1.domain.executor.ThreadExecutor
import com.searoth.wwe1.domain.repository.BufferooRepository
import com.searoth.wwe1.remote.BufferooRemoteImpl
import com.searoth.wwe1.remote.BufferooService
import com.searoth.wwe1.remote.BufferooServiceFactory
import com.searoth.wwe1.ui.BuildConfig
import com.searoth.wwe1.ui.UiThread
import com.searoth.wwe1.ui.injection.scopes.PerApplication

/**
 * Module used to provide dependencies at an application-level.
 */
@Module
open class ApplicationModule {

    @Provides
    @PerApplication
    fun provideContext(application: Application): Context {
        return application
    }

    @Provides
    @PerApplication
    internal fun providePreferencesHelper(context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }


    @Provides
    @PerApplication
    internal fun provideBufferooRepository(factory: BufferooDataStoreFactory,
                                           mapper: BufferooMapper): BufferooRepository {
        return BufferooDataRepository(factory, mapper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooCache(factory: DbOpenHelper,
                                      entityMapper: BufferooEntityMapper,
                                      mapper: com.searoth.wwe1.cache.db.mapper.BufferooMapper,
                                      helper: PreferencesHelper): BufferooCache {
        return BufferooCacheImpl(factory, entityMapper, mapper, helper)
    }

    @Provides
    @PerApplication
    internal fun provideBufferooRemote(service: BufferooService,
                                       factory: com.searoth.wwe1.remote.mapper.BufferooEntityMapper): BufferooRemote {
        return BufferooRemoteImpl(service, factory)
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
        return BufferooServiceFactory.makeBuffeoorService(BuildConfig.DEBUG)
    }
}
