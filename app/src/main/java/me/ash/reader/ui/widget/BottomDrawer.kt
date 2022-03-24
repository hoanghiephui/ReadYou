package me.ash.reader.ui.widget

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ExperimentalMaterialApi
import androidx.compose.material.ModalBottomSheetDefaults
import androidx.compose.material.ModalBottomSheetState
import androidx.compose.material.ModalBottomSheetValue
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.zIndex

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun BottomDrawer(
    modifier: Modifier = Modifier,
    drawerState: ModalBottomSheetState = androidx.compose.material.rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden
    ),
    content: @Composable () -> Unit = {},
) {
    androidx.compose.material.ModalBottomSheetLayout(
        sheetState = drawerState,
        sheetBackgroundColor = Color.Transparent,
        sheetElevation = if (drawerState.isVisible) ModalBottomSheetDefaults.Elevation else 0.dp,
        sheetContent = {
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .clip(
                        RoundedCornerShape(
                            topStart = 28.0.dp,
                            topEnd = 28.0.dp,
                            bottomEnd = 0.0.dp,
                            bottomStart = 0.0.dp
                        )
                    )
                    .background(MaterialTheme.colorScheme.surface)
                    .padding(horizontal = 28.dp)
                    .navigationBarsPadding()
            ) {
                Box {
                    Row(
                        modifier = modifier
                            .padding(top = 8.dp)
                            .fillMaxWidth(),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically,
                    ) {
                        Row(
                            modifier = modifier
                                .size(38.dp, 4.dp)
                                .background(MaterialTheme.colorScheme.outline.copy(alpha = 0.2f))
                                .zIndex(1f)
                        ) {}
                    }
                    Column {
                        Spacer(modifier = Modifier.height(40.dp))
                        content()
                        Spacer(modifier = Modifier.height(28.dp))
                    }
                }
            }
        },
        content = {}
    )
}