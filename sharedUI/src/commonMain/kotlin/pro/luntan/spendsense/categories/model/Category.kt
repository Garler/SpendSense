package pro.luntan.spendsense.categories.model

import kotlinx.datetime.LocalDateTime
import pro.luntan.spendsense.extensions.now

data class Category(
    val id: String,
    val title: String,
    val description: String,
    val createdAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val colorHex: String
){
    companion object {
        val NONE = Category(
            id = "NONE_CATEGORY",
            title = "",
            description = "",
            createdAt = LocalDateTime.now(),
            updateAt =  LocalDateTime.now(),
            colorHex = ""
        )
    }
}
