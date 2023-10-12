package NavigatoPage

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Card
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import recommend_page.RecommendPage

@Composable
fun NavigatoPage() {
    val scrollState = rememberScrollState()

    Row {
        Column(
            modifier = Modifier.background(Color(0xfff0f3f6))
                .width(225.dp).fillMaxHeight().verticalScroll(scrollState)
        ) {
            WYY()
            NavigatorItem()
        }

        RecommendPage()
    }
}

@Composable
fun WYY() {
    Row(
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier.padding(20.dp)
    ) {
        Image(painterResource("image/icon.png"), contentDescription = "", modifier = Modifier.size(25.dp))

        Text("网易云音乐", fontSize = 20.sp, fontWeight = FontWeight.Black, modifier = Modifier.padding(3.dp))

        Card(
            modifier = Modifier.clip(CircleShape).border(1.dp, Color(0xffaeb3bc), CircleShape).width(25.dp)
        ) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier.padding(1.dp)
            ) {
                Text("Beta", fontSize = 9.sp, color = Color(0xffaeb3bc))
            }
        }
    }
}

@Composable
fun NavigatorItem() {
    var selectedTabIndex1 by remember { mutableStateOf(0) }
    var selectedTabIndex2 by remember { mutableStateOf(-1) }

    val items = listOf(
        "为我推荐",
        "云音乐精选",
        "博客",
        "私人漫游",
        "社区",
        "我喜欢的音乐",
        "最近播放",
        "我的播客",
        "我的收藏",
        "下载管理",
        "本地音乐",
        "我的音乐盘"
    )

    Column {
        CustomBottomNavigation(
            items = items.take(5),
            selectedTabIndex = selectedTabIndex1
        ) {

            selectedTabIndex1 = if (selectedTabIndex1 == it) -1 else it
            selectedTabIndex2 = -1
        }

        Divider(
            color = Color(0xffebeff2),
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth().padding(10.dp)
        )
    }

    CustomBottomNavigation(
        items = items.takeLast(7),
        selectedTabIndex = selectedTabIndex2
    ) {

        selectedTabIndex2 = if (selectedTabIndex2 == it) -1 else it
        selectedTabIndex1 = -1
    }
}

