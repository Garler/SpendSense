package pro.luntan.spendsense.categories.list

import kotlinx.coroutines.launch
import kotlinx.datetime.LocalDateTime
import pro.luntan.spendsense.base.BaseViewModel
import pro.luntan.spendsense.base.BaseViewState
import pro.luntan.spendsense.categories.create.CreateCategoryData
import pro.luntan.spendsense.categories.create.toCategory
import pro.luntan.spendsense.categories.model.Category
import pro.luntan.spendsense.extensions.now
import pro.luntan.spendsense.categories.list.CategoriesViewModel.State
import pro.luntan.spendsense.categories.model.CategoriesRepository
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class CategoriesViewModel(
    private val repository: CategoriesRepository
) : BaseViewModel<State, Nothing>(){

    override fun initialState() = State.NONE

    init {
        activate()
    }

    private fun activate(){
        repository.getAllFlow().onEach {
            updateState { copy(categoties = it) }
        }.launchIn(viewModelScope)
    }

    fun createCategory(data: CreateCategoryData){
        val now = LocalDateTime.now()
        val category = data.toCategory(now)
        viewModelScope.launch {
            repository.create(category)
        }
    }

    data class State(
        val categoties: List<Category>
    ) : BaseViewState {

        companion object {
            val NONE = State(emptyList())
        }
    }
}