package pro.luntan.spendsense.categories.model

import kotlinx.coroutines.flow.flow
import pro.luntan.spendsense.extensions.appLog

class CategoriesRepository {
    fun getAllFlow() = flow { emit(Category.getStubs()) }

    suspend fun create(category: Category){
        appLog("created category: $category")
    }
}