package pro.luntan.spendsense.categories.create

import kotlinx.datetime.LocalDateTime
import pro.luntan.spendsense.categories.model.Category
import pro.luntan.spendsense.platform.randomUUID

data class CreateCategoryData(
    val title: String,
    val subtitle: String,
    val colorHex: String
)

fun CreateCategoryData.toCategory(dateTime: LocalDateTime) = Category(
    id = randomUUID(),
    title = title,
    description = subtitle,
    colorHex = colorHex,
    createdAt = dateTime,
    updatedAt = dateTime
)
