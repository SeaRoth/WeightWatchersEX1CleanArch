package com.searoth.wwe1.ui.injection.module

import dagger.Module
import dagger.Provides
import com.searoth.wwe1.domain.interactor.browse.GetBufferoos
import com.searoth.wwe1.presentation.browse.BrowseBufferoosContract
import com.searoth.wwe1.presentation.browse.BrowseBufferoosPresenter
import com.searoth.wwe1.presentation.mapper.BufferooMapper
import com.searoth.wwe1.ui.browse.BrowseActivity
import com.searoth.wwe1.ui.injection.scopes.PerActivity



/**
 * Module used to provide dependencies at an activity-level.
 */
@Module
open class BrowseActivityModule {

    @PerActivity
    @Provides
    internal fun provideBrowseView(browseActivity: BrowseActivity): BrowseBufferoosContract.View {
        return browseActivity
    }

    @PerActivity
    @Provides
    internal fun provideBrowsePresenter(mainView: BrowseBufferoosContract.View,
                                        getBufferoos: GetBufferoos, mapper: BufferooMapper):
            BrowseBufferoosContract.Presenter {
        return BrowseBufferoosPresenter(mainView, getBufferoos, mapper)
    }

}
