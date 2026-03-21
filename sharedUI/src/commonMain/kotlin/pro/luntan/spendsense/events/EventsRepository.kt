package pro.luntan.spendsense.events

import kotlinx.coroutines.flow.flow
import pro.luntan.spendsense.events.model.SpendEvent
import pro.luntan.spendsense.extensions.appLog

class EventsRepository {
    fun getAllFlow() = flow { emit(SpendEvent.getStubs()) }

    fun create(spendEvent: SpendEvent) = appLog("create event $spendEvent")
}