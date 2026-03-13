package pro.luntan.spendsense.categories

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetValue
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex
import kotlinx.coroutines.launch
import pro.luntan.spendsense.categories.create.compose.CreateCategoryView
import pro.luntan.spendsense.categories.list.CategoriesViewModel
import pro.luntan.spendsense.categories.list.compose.CategoriesListView
import pro.luntan.spendsense.common.ui.atoms.FAB
import pro.luntan.spendsense.common.ui.atoms.RootBox

@OptIn(ExperimentalMaterial3Api::class, ExperimentalComposeUiApi::class)
@Composable
fun CategoriesScreen(
    viewModel: CategoriesViewModel
) {
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    val scope = rememberCoroutineScope()

    RootBox {
        CategoriesListView(viewModel, Modifier.fillMaxSize().padding(8.dp)) {

        }
        FAB { scope.launch { sheetState.show() } }
    }

    if (sheetState.isVisible) {
        ModalBottomSheet(
            content = {
                CreateCategoryView(
                    isExpand = sheetState.currentValue == SheetValue.Expanded
                ) { data ->
                    scope.launch { sheetState.hide() }
                    viewModel.createCategory(data)
                }
            },
            sheetState = sheetState,
            containerColor = Color.Transparent,
            modifier = Modifier.zIndex(1f),
            onDismissRequest = { scope.launch { sheetState.hide() } }
        )
    }
}