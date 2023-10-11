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
import page

@Composable
fun NavigatoPage(){
    var selectedTabIndex by remember { mutableStateOf(0) }

    var selectedTabIndex2 by remember { mutableStateOf(0) }

    val items = listOf("为我推荐", "云音乐精选", "博客", "私人漫游", "社区")

    val items2= listOf("我喜欢的音乐","最近播放","我的播客","我的收藏","下载管理","本地音乐","我的音乐盘")

    val scrollState = rememberScrollState()

    Row {
        Column(
            modifier = Modifier
                .background(Color(0xfff0f3f6))
                .width(250.dp)
                .fillMaxHeight()
                .verticalScroll(scrollState)
        ) {
            Column {
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

                CustomBottomNavigation(items = items, selectedTabIndex = selectedTabIndex) {
                    selectedTabIndex = it
                }

                Divider(
                    color = Color(0xffebeff2),
                    thickness = 1.dp,
                    modifier = Modifier.fillMaxWidth().padding(10.dp)
                )

                CustomBottomNavigation(items = items2, selectedTabIndex = selectedTabIndex2) {
                    selectedTabIndex2 = it
                }
            }
        }

        page()
    }

}