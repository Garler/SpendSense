package pro.luntan.spendsense.categories

import pro.luntan.spendsense.categories.model.Category
import pro.luntan.spendsense.categories.model.CategoryDao

class CategoriesRepository (
    private val dao: CategoryDao
) {
    fun getAllFlow() = dao.getAllFlow()

    suspend fun create(category: Category) = dao.insert(category)
}