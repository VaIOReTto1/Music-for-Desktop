package recommend_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun RecommendPlaylist() {
    Box(
        modifier = Modifier.width(225.dp).padding(start = 15.dp, top = 5.dp, end = 14.dp)
            .clip(RoundedCornerShape(15.dp)).height(260.dp)
    ) {
        Image(
            painter = painterResource("image/ic_disk_place_holder.webp"),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )
    }
}

@Composable
fun RecommendList() {
    Column(
        modifier = Modifier.padding(bottom = 21.dp, top = 7.dp, start = 38.dp)
    ) {

        Text(
            "推荐歌单 > ",
            fontWeight = FontWeight.Bold,
            fontSize = 22.sp,
            color = Color(0xff343e52),
            modifier = Modifier.padding(start = 15.dp, bottom = 10.dp)
        )

        Row {
            repeat(4) {
                RecommendPlaylist()
            }
        }
    }
}