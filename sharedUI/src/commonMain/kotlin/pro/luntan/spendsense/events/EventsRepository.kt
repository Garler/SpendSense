package pro.luntan.spendsense.events

import pro.luntan.spendsense.events.model.SpendEvent
import pro.luntan.spendsense.events.model.SpendEventDao

class EventsRepository (
    private val dao: SpendEventDao
) {
    fun getAllFlow() = dao.getAllFlow()

    suspend fun create(spendEvent: SpendEvent) = dao.insert(spendEvent)
}