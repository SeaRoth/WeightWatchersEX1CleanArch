package com.searoth.wwe1.ui.injection.module

import dagger.Module
import dagger.android.ContributesAndroidInjector
import com.searoth.wwe1.ui.browse.BrowseActivity
import com.searoth.wwe1.ui.injection.scopes.PerActivity

@Module
abstract class ActivityBindingModule {

    @PerActivity
    @ContributesAndroidInjector(modules = arrayOf(BrowseActivityModule::class))
    abstract fun bindMainActivity(): BrowseActivity

}