package pro.luntan.spendsense.di

import org.koin.core.qualifier.Qualifier
import org.koin.core.qualifier.QualifierValue
import org.koin.dsl.module
import org.koin.ext.getFullName
import pro.luntan.spendsense.categories.list.CategoriesViewModel
import pro.luntan.spendsense.categories.model.CategoriesRepository
import pro.luntan.spendsense.common.ui.calendar.DatePickerViewModel
import pro.luntan.spendsense.events.EventsRepository
import pro.luntan.spendsense.events.create.CreateEventViewModel
import pro.luntan.spendsense.events.list.EventsViewModel
import pro.luntan.spendsense.platform.DeviceInfo
import pro.luntan.spendsense.root.RootViewModel
import pro.luntan.spendsense.settings.SettingsViewModel
import pro.luntan.spendsense.storage.SettingsManager

object CoreModule {
    val deviceInfo = module  {
        single { DeviceInfo() }
    }
}

object StorageModule {
    val settings = module {
        single { SettingsManager(get()) }
    }
}

object RepositoriesModule {
    val repositories = module {
        single { CategoriesRepository() }
        single { EventsRepository() }
    }
}

object ViewModelsModule{
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

object DatePickerSingleQualifier: Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}

object DatePickerFactoryQualifier: Qualifier {
    override val value: QualifierValue
        get() = this::class.getFullName()
}