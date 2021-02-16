package top.zcwfeng.compose.mydemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.layout.layout
import androidx.compose.ui.platform.AmbientAnimationClock
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import top.zcwfeng.compose.mydemo.ui.*
import top.zcwfeng.compose.mydemo.ui.theme.MyDemoTheme
import kotlin.math.roundToInt

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        /**
         * 设置装饰视图是否适合WindowInsetsCompat的根目录内容视图。
         * 如果设置为false，则框架将使内容视图不适合插入，
         * 而仅将WindowInsetsCompat传递到内容视图。
         */
        WindowCompat.setDecorFitsSystemWindows(window, false)
        val viewModel: WeViewModel by viewModels()

        setContent {

            MyDemoTheme(theme = viewModel.theme) {
                Home(AmbientAnimationClock)
            }
        }
    }

    override fun onBackPressed() {
        val viewModel: WeViewModel by viewModels()
        if (viewModel.openModule != null) {
            viewModel.endChat()
        } else {
            super.onBackPressed()
        }

    }





}

fun Modifier.unread(show: Boolean, bagdgeColor: Color) = this.drawWithContent {
    drawContent()
    if (show) {
        drawIntoCanvas { canvas ->
            val paint = Paint().apply {
                color = bagdgeColor
            }
            canvas.drawCircle(
                Offset(
                    size.width - 1.dp.toPx(),
                    1.dp.toPx()
                ),
                5.dp.toPx(),
                paint
            )
        }
    }
}

fun Modifier.percentOffsetX(percent: Float) = this.layout { measurable, constraints ->
    val placeable = measurable.measure(constraints)
    layout(placeable.width, placeable.height) {
        placeable.placeRelative(IntOffset((placeable.width * percent).roundToInt(), 0))
    }
}