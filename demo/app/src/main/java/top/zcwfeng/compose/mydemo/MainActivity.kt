package top.zcwfeng.compose.mydemo

import android.os.Bundle
import androidx.annotation.DrawableRes
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material.Icon
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import top.zcwfeng.compose.mydemo.ui.theme.MyDemoTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyDemoTheme {
               Column {
                   Row {
                       TabItem(R.drawable.ic_launcher_background,"我的")
                   }
               }
            }
        }
    }

    @Composable
    private fun TabItem(@DrawableRes iconId:Int,title:String) {
        Column {

            Icon(vectorResource(iconId))
            Text(title)
        }
    }
}
