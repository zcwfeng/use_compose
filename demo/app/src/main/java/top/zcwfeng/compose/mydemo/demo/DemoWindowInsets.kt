package top.zcwfeng.compose.mydemo.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.view.WindowCompat
import dev.chrisbanes.accompanist.insets.ProvideWindowInsets
import dev.chrisbanes.accompanist.insets.navigationBarsPadding
class DemoWindowInsets : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        WindowCompat.setDecorFitsSystemWindows(window, false)
        setContent {
            WindowInsetsStory()
        }
    }


}
@Composable
fun WindowInsetsStory() {
    MaterialTheme {
        ProvideWindowInsets {
            // your content
            FloatingActionButton(
                onClick = { /* TODO */ },
                modifier = Modifier
                    .padding(16.dp) // normal 16dp of padding for FABs
                    .navigationBarsPadding() // Move it out from under the nav bar
//                    .align(Alignment.BottomEnd)

            ) {
                Icon(imageVector = Icons.Default.Add, contentDescription = null)
            }
        }
    }
}
@Preview(showBackground = true)
@Composable
fun WindowInsetsStoryPreview(){
    WindowInsetsStory()
}

//@Composable
//fun ImeAvoidingBox() {
//    val insets = LocalWindowInsets.current
//
//    val imeBottom = with(LocalDensity.current) { insets.ime.bottom.toDp() }
//    Box(Modifier.padding(bottom = imeBottom))
//}