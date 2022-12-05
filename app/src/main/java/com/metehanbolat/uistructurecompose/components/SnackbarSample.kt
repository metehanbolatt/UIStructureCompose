package com.metehanbolat.uistructurecompose.components

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import kotlinx.coroutines.launch

@Composable
fun SnackbarSample() {

    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember { mutableStateOf("") }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            TextField(
                value = textFieldState,
                label = {
                    Text(text = "Enter your name")
                },
                onValueChange = { textFieldState = it },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(
                onClick = {
                    scope.launch {
                        scaffoldState.snackbarHostState.showSnackbar(
                            message = "Hello $textFieldState",
                            actionLabel = "Close",
                            duration = SnackbarDuration.Short
                        )
                    }
                }
            ) {
                Text(text = "Button")
            }
        }
    }
}

@Preview
@Composable
fun SnackbarSamplePreview() {
    SnackbarSample()

}