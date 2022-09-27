package com.metehanbolat.uistructurecompose.login

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.zIndex
import com.metehanbolat.uistructurecompose.R
import com.metehanbolat.uistructurecompose.ui.theme.primaryColor
import com.metehanbolat.uistructurecompose.ui.theme.whiteBackground

@Composable
fun LoginPage() {

    val emailValue = remember { mutableStateOf("") }
    val passwordValue = remember { mutableStateOf("") }
    val passwordVisibility = remember { mutableStateOf(false) }

    Box(
        modifier = Modifier.fillMaxSize(),
        contentAlignment = Alignment.BottomCenter
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .fillMaxHeight(0.6f)
                .background(Color.White)
                .padding(10.dp)
        ) {

            Image(
                painter = painterResource(id = R.drawable.login_image),
                contentDescription = null
            )

            Text(
                text = stringResource(id = R.string.sign_in),
                style = TextStyle(fontWeight = FontWeight.Bold, letterSpacing = 2.sp),
                fontSize = 30.sp
            )
            Spacer(modifier = Modifier.padding(20.dp))
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                OutlinedTextField(
                    value = emailValue.value,
                    onValueChange = { emailValue.value = it },
                    label = { Text(text = stringResource(id = R.string.email_address)) },
                    placeholder = { Text(text = stringResource(id = R.string.email_address)) },
                    singleLine = true,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                OutlinedTextField(
                    value = passwordValue.value,
                    onValueChange = { passwordValue.value = it },
                    trailingIcon = {
                        IconButton(onClick = {
                            passwordVisibility.value = !passwordVisibility.value
                        }) {
                            Icon(
                                imageVector = ImageVector.vectorResource(id = R.drawable.ic_password_eye),
                                contentDescription = null,
                                tint = if (passwordVisibility.value) primaryColor else Color.Gray
                            )
                        }
                    },
                    label = { Text(text = stringResource(id = R.string.password)) },
                    placeholder = { Text(text = stringResource(id = R.string.password)) },
                    singleLine = true,
                    visualTransformation = if (passwordVisibility.value) VisualTransformation.None else PasswordVisualTransformation(),
                    modifier = Modifier.fillMaxWidth(0.8f)
                )

                Spacer(modifier = Modifier.padding(10.dp))

                Button(
                    modifier = Modifier
                        .fillMaxWidth(0.8f)
                        .height(50.dp),
                    onClick = { }
                ) {
                    Text(text = stringResource(id = R.string.sign_in), fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.padding(20.dp))

                Text(
                    text = stringResource(id = R.string.create_an_account),
                    modifier = Modifier.clickable { }
                )
            }
        }
    }
}

@Preview
@Composable
fun LoginPagePreview() {
    LoginPage()
}