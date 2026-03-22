package pro.luntan.spendsense.events.create

import kotlinx.datetime.LocalDate
import kotlinx.datetime.LocalDateTime
import pro.luntan.spendsense.base.BaseEvent
import pro.luntan.spendsense.base.BaseViewModel
import pro.luntan.spendsense.base.BaseViewState
import pro.luntan.spendsense.categories.model.Category
import pro.luntan.spendsense.events.model.SpendEvent
import pro.luntan.spendsense.events.create.CreateEventViewModel.*
import pro.luntan.spendsense.extensions.now
import pro.luntan.spendsense.platform.randomUUID

class CreateEventViewModel : BaseViewModel<State, Event>() {

    override fun initialState() = State.NONE

    fun selectDate(date: LocalDate?) = updateState { copy(date = date ?: LocalDate.now()) }
    fun resetState() = updateState { State.NONE }
    fun changeTitle(title: String) = updateState { copy(title = title) }
    fun changeCost(cost: String) = updateState { copy(cost = cost.toDoubleOrNull() ?: this.cost) }
    fun selectCategory(category: Category) = updateState { copy(category = category) }

    fun finish() {
        val spendEvent = with(state.value){
            val now = LocalDateTime.now()
            SpendEvent(
                id = randomUUID(),
                title = title,
                cost = cost,
                date = date,
                categoryId = category.id,
                createdAt = now,
                updatedAt = now,
                note = note
            )
        }
        resetState()
        pushEvent(Event.Finish(spendEvent))
    }


    data class State(
        val title: String,
        val category: Category,
        val date: LocalDate,
        val cost: Double,
        val note: String
    ) : BaseViewState {
        companion object {
            val NONE = State(
                title = "",
                category = Category.NONE,
                date = LocalDate.now(),
                cost = 0.0,
                note = ""
            )
        }
    }

    sealed interface Event : BaseEvent {
        data class Finish(val spendEvent: SpendEvent) : Event
    }

}