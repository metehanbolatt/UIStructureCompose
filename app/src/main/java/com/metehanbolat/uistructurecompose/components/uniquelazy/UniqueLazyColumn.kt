package com.metehanbolat.uistructurecompose.components.uniquelazy

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun UniqueLazyScreen() {
    val itemList2 = listOf(
        Item(1, "Raptor"),
        Item(2, "Iron Impact"),
        Item(3, "Hell Breaker"),
        Item(4, "Elixir"),
        Item(5, "Iron Belt"),
        Item(6, "Shard"),
        Item(7, "Mirage Dagger")
    )

    val _elements = remember { mutableStateListOf<Item>() }
    val elements: List<Item> = _elements

    Column {
        Button(
            onClick = {
                _elements.add(
                    Item(
                        8, "Cleaver"
                    )
                )
                println(elements)
            }
        ) {
            Text(text = "Button")
        }
        LazyColumn {
            items(elements, key = { item -> item.id }) {
                Text(text = it.name)
            }
        }
    }

}

data class Item(
    val id: Int,
    val name: String
)

@Preview
@Composable
fun UniqueLazyScreenPreview() {
    UniqueLazyScreen()
}