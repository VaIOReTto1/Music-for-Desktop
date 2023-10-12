package NavigatoPage

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp

@Composable
fun CustomBottomNavigation(
    items: List<String>,
    selectedTabIndex: Int,
    onTabSelected: (Int) -> Unit, ) {

    Column (
        modifier = Modifier.fillMaxWidth().padding(8.dp),) {

        items.forEachIndexed { index, item ->
            val isSelected = selectedTabIndex == index
            val textColor = if (isSelected) Color.White else Color(0xffa4a9b3)
            val backgroundColor = if (isSelected) Color(0xfffc3d49) else Color.Transparent

            Box(
                modifier = Modifier
                    .padding(start = 8.dp,end=8.dp, bottom = 5.dp, top = 5.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(5.dp))
                    .background(backgroundColor)
                    .clickable {
                        if (!isSelected) {
                            onTabSelected(index)
                        }}) {

                Text(
                    text = item,
                    color = textColor,
                    modifier = Modifier.padding(8.dp)
                )
            }
        }
    }
}
