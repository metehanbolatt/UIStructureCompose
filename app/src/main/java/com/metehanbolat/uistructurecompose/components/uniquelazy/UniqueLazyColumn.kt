package com.metehanbolat.uistructurecompose.components.uniquelazy

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

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

@ExperimentalFoundationApi
@Preview(showBackground = true)
@Composable
fun LazyTest() {
    val sections = listOf("Vadeli Hesaplar", "Vadesiz Hesaplar", "Altın Hesapları", "Döviz Hesapları")
    LazyColumn(
        contentPadding = PaddingValues(12.dp),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        sections.forEach { section ->
            stickyHeader {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Color.Green)
                        .wrapContentWidth()
                        .padding(12.dp),
                    text = section,
                )
            }
            items(10) {
                Card(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        modifier = Modifier.padding(12.dp),
                        text = "$section: Hesap $it"
                    )
                }
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