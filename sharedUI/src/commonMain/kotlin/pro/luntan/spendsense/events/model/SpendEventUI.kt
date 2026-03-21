package pro.luntan.spendsense.events.model

import pro.luntan.spendsense.categories.model.Category

data class SpendEventUI(
    val id: String,
    val category: Category,
    val title: String,
    val cost: Double
)
