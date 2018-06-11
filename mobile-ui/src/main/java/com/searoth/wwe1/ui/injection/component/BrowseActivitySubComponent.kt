package com.searoth.wwe1.ui.injection.component

import dagger.Subcomponent
import dagger.android.AndroidInjector
import com.searoth.wwe1.ui.browse.BrowseActivity

@Subcomponent
interface BrowseActivitySubComponent : AndroidInjector<BrowseActivity> {

    @Subcomponent.Builder
    abstract class Builder : AndroidInjector.Builder<BrowseActivity>()

}