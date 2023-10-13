package recommend_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp

@Composable
fun RecommendPage() {
    val scrollState = rememberScrollState()
    Column(
        modifier = Modifier.background(Color(0xfff0f3f6))
            .fillMaxWidth().fillMaxHeight().verticalScroll(scrollState)
    ) {
        appbar()

        Row(
            modifier = Modifier.padding(bottom = 21.dp, top = 21.dp)
        ) {
            RecommendBanner()

            Box(
                modifier = Modifier.width(495.dp).padding(start = 12.dp, top = 14.dp, end = 27.5.dp)
                    .clip(RoundedCornerShape(15.dp)).height(207.dp)
            ) {
                Image(
                    painter = painterResource("image/icon.png"),
                    contentDescription = null,
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.fillMaxSize()
                )
            }
        }

        RecommendList()
    }
}




