package pro.luntan.spendsense.di

import org.koin.dsl.module
import pro.luntan.spendsense.common.ui.calendar.DatePickerViewModel
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

object ViewModelsModule{
    val viewModels = module {
        single { RootViewModel(get()) }
        factory { SettingsViewModel(get(), get()) }
        single { DatePickerViewModel() }
    }
}