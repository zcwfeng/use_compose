package top.zcwfeng.compose.mydemo.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.animation.animateColorAsState
import androidx.compose.animation.core.TweenSpec
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import top.zcwfeng.compose.mydemo.ui.theme.MyDemoTheme

class MainActivityDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyApp {
                Greeting1(name = "Android3")
            }
        }
    }
}

@Composable
fun Greeting1(name: String) {
    // 记录选中状态
    var isSelected by remember { mutableStateOf(false) }

    val backgroundColor by animateColorAsState(if (isSelected) Color.Red else Color.Transparent)

    Text(text = "Hello $name!", modifier = Modifier
        .padding(24.dp)
        .background(color = backgroundColor)
        .clickable(onClick = { isSelected = !isSelected }),
    style= MaterialTheme.typography.h6.copy(color=Color.DarkGray))
}

@Composable
fun MyApp(content: @Composable () -> Unit) {
    MyDemoTheme {
        Surface(color = Color.Yellow) {
            content()
        }
    }
}

@Composable
fun nameList(names: List<String>, modifier: Modifier = Modifier) {
    LazyColumn(modifier = modifier) {
        items(count = names.size) { index ->
            Greeting1(name = names.get(index))
            Divider(color = Color.Black)
        }
    }
}

@Composable
fun MyScreenContent(names: List<String> = List(1000) { "Hello Android #$it" }) {
    val countState = remember { mutableStateOf(0) }
    Column(modifier = Modifier.fillMaxHeight()) {
        nameList(names = names, Modifier.weight(1f))
        Counter(count = countState.value,
            updateCount = { newCount -> countState.value = newCount })
    }

}

@Composable
fun Counter(count: Int, updateCount: (Int) -> Unit) {
    Button(
        onClick = { updateCount(count + 1) },
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (count > 3) Color.Green else Color.White
        )
    ) {

        Text("click $count times")
    }
}


@Preview("Text preview")
@Composable
fun DefaultPreview1() {
    Column {
        MyApp {
            MyScreenContent()
        }
    }
}