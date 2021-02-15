package top.zcwfeng.compose.mydemo.ui

import androidx.compose.animation.core.animateAsState
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.layout
import androidx.compose.ui.viewinterop.viewModel
import top.zcwfeng.compose.mydemo.WeViewModel
import kotlin.math.roundToInt

@Composable
fun ChatPage() {
    val viewModel: WeViewModel = viewModel()
    val percentOffsetX = animateFloatAsState(
        targetValue =
        if (viewModel.chatting) 0f else 1f
    )
    Box(
        Modifier
            // 相当于没写，但是可以进行后续的操作
            .percentOffsetX(percentOffsetX.value)
            .background(Color.DarkGray)
            .fillMaxSize()
    ) {

    }
}

fun Modifier.percentOffsetX(persent: Float): Modifier =
    this.layout { measurable, constraints ->
        val placebale = measurable.measure(constraints)
        layout(
            placebale.width,
            placebale.height
        )
        {
            val offset = (persent * placebale.width).roundToInt()
            placebale.placeRelative(offset, 0)
        }
    }