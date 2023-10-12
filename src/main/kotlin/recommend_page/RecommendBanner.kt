package recommend_page

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import java.awt.event.ActionEvent
import java.awt.event.ActionListener
import javax.swing.Timer

@Composable
fun RecommendBanner() {
    val imageResourceIds = listOf(
        "image/ic_disk_place_holder.webp",
        "image/icon.png",
        "image/ic_disk_place_holder.webp",
        "image/icon.png",
        "image/ic_disk_place_holder.webp",
        "image/icon.png",
        "image/ic_disk_place_holder.webp",
        "image/icon.png",
    )

    Box(
        modifier = Modifier.width(495.dp).padding(start = 52.dp, top = 14.dp, end = 12.dp).clip(RoundedCornerShape(15.dp)).height(207.dp)
    ) {
        ImageSlider(images = imageResourceIds)
    }
}

@Composable
fun ImageSlider(images: List<String>) {
    var currentIndex by remember { mutableStateOf(0) }
    var timer by remember { mutableStateOf<Timer?>(null) }

    val colorActive = Color.White
    val colorInactive = Color.Gray

    Box(
        modifier = Modifier.fillMaxSize()
    ) {

        val currentImage = images[currentIndex]

        Image(
            painter = painterResource(currentImage),
            contentDescription = null,
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

        DisposableEffect(images) {
            timer = Timer(3000, object : ActionListener {
                override fun actionPerformed(e: ActionEvent?) {
                    currentIndex = (currentIndex + 1) % images.size
                }
            })

            timer?.start()
            onDispose {
                timer?.stop()
            }
        }
    }

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 180.dp),
        contentAlignment = Alignment.Center
    ) {

        Row(
            horizontalArrangement = Arrangement.spacedBy(10.dp),
        ) {

            images.forEachIndexed { index, _ ->
                val color = if (index == currentIndex) colorActive else colorInactive

                Box(
                    modifier = Modifier
                        .size(10.dp)
                        .background(color, CircleShape)
                        .graphicsLayer { translationY = 4.dp.toPx() }
                )
            }
        }
    }
}
