import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import com.metehanbolat.uistructurecompose.ui.theme.UIStructureComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            UIStructureComposeTheme {

                var myBoolean = false
                var myValue by remember { mutableStateOf(false) }

                Column(
                    modifier = Modifier.fillMaxSize(),
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.Center
                ) {
                    MyView(text = myBoolean) {
                        myBoolean = !myBoolean
                    }
                    MyView(text = myValue) {
                        myValue = !myValue
                    }
                }
            }
        }
    }
}

@Composable
fun MyView(text: Boolean, onClick: () -> Unit) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = { onClick() }
        ) {
            Text(text = "Button")
        }
        Text(text = text.toString())
    }
}