package com.searoth.wwe1.ui.injection

import android.app.Application
import dagger.BindsInstance
import dagger.Component
import dagger.android.support.AndroidSupportInjectionModule
import com.searoth.wwe1.ui.BufferooApplication
import com.searoth.wwe1.ui.injection.module.ActivityBindingModule
import com.searoth.wwe1.ui.injection.module.ApplicationModule
import com.searoth.wwe1.ui.injection.scopes.PerApplication

@PerApplication
@Component(modules = arrayOf(ActivityBindingModule::class, ApplicationModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent {

    @Component.Builder
    interface Builder {
        @BindsInstance fun application(application: Application): Builder
        fun build(): ApplicationComponent
    }

    fun inject(app: BufferooApplication)

}
