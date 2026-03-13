package pro.luntan.spendsense.categories.list.compose

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import pro.luntan.spendsense.categories.list.CategoriesViewModel
import pro.luntan.spendsense.categories.model.Category

@Composable
fun CategoriesListView(
    viewModel: CategoriesViewModel,
    modifier: Modifier,
    onClick: (Category) -> Unit
) {

    val state by viewModel.state.collectAsState()

    LazyColumn(modifier = modifier) {
        items(state.categoties) { category ->
            CategoryItem(category){ onClick(category) }
        }
    }
}