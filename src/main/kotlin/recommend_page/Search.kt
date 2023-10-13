package recommend_page

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Icon
import androidx.compose.material.TextField
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.KeyboardArrowLeft
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun appbar() {
    Row(
        modifier = Modifier.padding(start = 52.dp, top = 15.dp, bottom = 15.dp),
    ) {
        backIcon()

        search()
    }
}

@Composable
fun backIcon() {
    Box(
        modifier = Modifier.padding(end = 12.dp)
    ){
        Column(
            modifier = Modifier.height(35.dp).width(28.dp).clip(RoundedCornerShape(4.dp))
                .border(1.dp, color = Color(0xffd9dde3), shape = RoundedCornerShape(4.dp)).background(
                    Color(0xfff0f3f6)
                ),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Icon(
                Icons.Rounded.KeyboardArrowLeft, contentDescription = null, tint = Color(0xffd9dde3)
            )
        }
    }
}

@Composable
fun search() {
    var textValue by remember { mutableStateOf("") }

    TextField(
        value = textValue,
        onValueChange = { textValue = it },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontWeight = FontWeight.Thin,
            color = Color(0xffc3c6d3),
            letterSpacing = 2.sp
        ),
        modifier = Modifier.width(350.dp).height(35.dp).clip(RoundedCornerShape(10.dp))
            .background(color = Color.White),
        visualTransformation = VisualTransformation.None,
        singleLine = true
    )
}