package top.zcwfeng.compose.mydemo.demo

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

class ColumnDemo : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewStory()
        }
    }
}

@Composable
fun NewStory() {
    Column(
        Modifier.padding(16.dp, 16.dp, 16.dp, 16.dp)
    ) {
        Text("起灵老师今天再发呆")
        Text("靖哥哥今天在练字")
        Text("传伟今天在打游戏")
    }
}

@Preview(showBackground = true)
@Composable
fun NewStoryPreView() {
    NewStory()
}




