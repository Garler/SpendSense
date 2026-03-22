package pro.luntan.spendsense.di

import db.categories.CategoryDb
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.dsl.module
import org.koin.ext.getFullName
import pro.luntan.spendsense.categories.list.CategoriesViewModel
import pro.luntan.spendsense.categories.CategoriesRepository
import pro.luntan.spendsense.categories.model.CategoryDao
import pro.luntan.spendsense.common.ui.calendar.DatePickerViewModel
import pro.luntan.spendsense.db.AppDb
import pro.luntan.spendsense.events.EventsRepository
import pro.luntan.spendsense.events.create.CreateEventViewModel
import pro.luntan.spendsense.events.list.EventsViewModel
import pro.luntan.spendsense.events.model.SpendEventDao
import pro.luntan.spendsense.platform.DeviceInfo
import pro.luntan.spendsense.root.RootViewModel
import pro.luntan.spendsense.settings.SettingsViewModel
import pro.luntan.spendsense.storage.DbAdapters
import pro.luntan.spendsense.storage.SettingsManager

object CoreModule {
    val deviceInfo = module {
        single { DeviceInfo() }
        factory { Dispatchers.Default + SupervisorJob() }
    }
}

object StorageModule {
    val settings = module {
        single { SettingsManager(get()) }
    }
    val db = module {
        single {
            AppDb(get(), DbAdapters.categoryDbAdapter, DbAdapters.eventDbAdapter)
        }
    }
    val dao = module {
        single { CategoryDao(get(), get()) }
        single { SpendEventDao(get(), get()) }
    }
}

object RepositoriesModule {
    val repositories = module {
        single { CategoriesRepository(get()) }
        single { EventsRepository(get()) }
    }
}

object ViewModelsModule {
    val viewModels = module {
        single { RootViewModel(get()) }
        factory { SettingsViewModel(get(), get()) }
        single(DatePickerSingleQualifier) { DatePickerViewModel() }
        factory(DatePickerFactoryQualifier) { DatePickerViewModel() }
        factory { EventsViewModel(get(), get()) }
        single { CategoriesViewModel(get()) }
        factory { CreateEventViewModel() }
    }
}

object DatePickerSingleQualifier : Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}

object DatePickerFactoryQualifier : Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}