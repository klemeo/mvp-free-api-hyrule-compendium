package ru.android.hyrulecompendiummvp.app

import org.koin.dsl.module
import ru.android.hyrulecompendiummvp.api.Api
import ru.android.hyrulecompendiummvp.api.ApiImpl
import ru.android.hyrulecompendiummvp.app.models.repository.Repository
import ru.android.hyrulecompendiummvp.app.models.repository.RepositoryImpl
import ru.android.hyrulecompendiummvp.base.SchedulerComposerFactory
import ru.android.hyrulecompendiummvp.base.ScreensManager
import ru.android.hyrulecompendiummvp.base.ScreensManagerImpl

private val allModule = module {

    //appModule
    factory {
        SchedulerComposerFactory.android()
    }

    single<ScreensManager> {
        ScreensManagerImpl()
    }
    //endregion

    //apiModule
    single<Api> {
        ApiImpl()
    }
    //endregion

    //dataModule
    single<Repository> {
        RepositoryImpl(
            api = get<Api>().getApi()
        )
    }
    //endregion

}

val modules = listOf(allModule)