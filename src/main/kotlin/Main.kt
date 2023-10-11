import NavigatoPage.NavigatoPage
import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import androidx.compose.ui.window.rememberWindowState

@Composable
@Preview
fun App() {
    NavigatoPage()
}



fun main() = application {
    Window(onCloseRequest = ::exitApplication, state = rememberWindowState(width = 1200.dp, height = 750.dp)) {
        App()
    }
}

@Composable
fun page(){
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(20.dp)
    ) {
        Image(painterResource("image/icon.png"), contentDescription = "", modifier = Modifier.size(25.dp))
        Text("网易云音乐", fontSize = 20.sp, fontWeight = FontWeight.Black, modifier = Modifier.padding(3.dp))
        Card(
            modifier = Modifier.clip(CircleShape).border(1.dp, Color.Black, CircleShape).width(25.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(1.dp)
            ) {
                Text("Beta", fontSize = 9.sp, color = Color.Gray)
            }
        }
    }
}
