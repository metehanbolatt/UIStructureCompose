package com.metehanbolat.uistructurecompose.components.expandedwithconditions

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material.Button
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun ModifierInConditionsItem() {

    var name by remember { mutableStateOf("") }
    var expanded by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = name,
            onValueChange = { name = it },
            modifier = Modifier
                .run {
                    if (expanded) fillMaxWidth(0.8f) else fillMaxWidth(0.5f)
                },
            singleLine = true
            )
        Spacer(modifier = Modifier.height(20.dp))

        Button(onClick = { expanded = !expanded }) {
            Text(text = "Button")
        }

    }
}

@Preview(showBackground = true)
@Composable
fun ModifierInConditionsItemPreview() {
    ModifierInConditionsItem()
}