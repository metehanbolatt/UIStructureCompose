package com.metehanbolat.uistructurecompose.components.context_drop_down_menu

import androidx.compose.foundation.LocalIndication
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.indication
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material.DropdownMenu
import androidx.compose.material.DropdownMenuItem
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.DpOffset
import androidx.compose.ui.unit.dp

@Composable
fun ContextScreenDropDown(
    dropDownItems: List<String>,
    onItemClick: (String) -> Unit,
    content: @Composable () -> Unit
) {
    var isContextMenuVisible by rememberSaveable { mutableStateOf(false) }
    var pressOffset by remember { mutableStateOf(DpOffset.Zero) }
    var itemHeight by remember { mutableStateOf(0.dp) }
    val density = LocalDensity.current
    val interactionSource = remember { MutableInteractionSource() }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .onSizeChanged { itemHeight = with(density) { it.height.toDp() } }
            .indication(interactionSource, LocalIndication.current)
            .pointerInput(true) {
                detectTapGestures(
                    onLongPress = {
                        isContextMenuVisible = true
                        pressOffset = DpOffset(it.x.toDp(), it.y.toDp())
                    }
                )
            },
        contentAlignment = Alignment.Center
    ) {
        content()
    }

    DropdownMenu(
        expanded = isContextMenuVisible,
        onDismissRequest = { isContextMenuVisible = false },
        offset = pressOffset.copy(
            y = pressOffset.y - itemHeight
        )
    ) {
        dropDownItems.forEach { item ->
            DropdownMenuItem(
                onClick = {
                    onItemClick(item)
                    isContextMenuVisible = false
                }
            ) {
                Text(text = item)
            }
        }
    }
}

@Preview
@Composable
fun ContextScreenDropDownPreview() {
    ContextScreenDropDown(
        dropDownItems = listOf("Metehan", "Bolat"),
        onItemClick = { println("test: $it") }
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp),
            contentPadding = PaddingValues(15.dp)
        ) {
            items(
                listOf(
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan",
                    "Metehan"
                )
            ) {
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { println("Clicked") }
                ) {
                    Text(text = it, modifier = Modifier.padding(15.dp))
                }
            }
        }
    }
}