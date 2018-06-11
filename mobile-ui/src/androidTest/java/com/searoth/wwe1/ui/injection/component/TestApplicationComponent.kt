package com.searoth.wwe1.ui.injection.component

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.searoth.wwe1.domain.executor.PostExecutionThread
import com.searoth.wwe1.domain.repository.BufferooRepository
import com.searoth.wwe1.ui.injection.ApplicationComponent
import com.searoth.wwe1.ui.injection.module.ActivityBindingModule
import com.searoth.wwe1.ui.injection.module.TestApplicationModule
import com.searoth.wwe1.ui.injection.scopes.PerApplication
import com.searoth.wwe1.ui.test.TestApplication

@Component(modules = arrayOf(TestApplicationModule::class, ActivityBindingModule::class,
        AndroidSupportInjectionModule::class))
@PerApplication
interface TestApplicationComponent : ApplicationComponent {

    fun bufferooRepository(): BufferooRepository

    fun postExecutionThread(): PostExecutionThread

    fun inject(application: TestApplication)

    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): TestApplicationComponent.Builder

        fun build(): TestApplicationComponent
    }

}