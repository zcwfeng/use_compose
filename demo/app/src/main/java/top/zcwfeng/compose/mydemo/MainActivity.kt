package top.zcwfeng.compose.mydemo

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientAnimationClock
import androidx.compose.ui.platform.setContent
import androidx.compose.ui.viewinterop.viewModel
import androidx.lifecycle.ViewModel
import top.zcwfeng.compose.mydemo.ui.*
import top.zcwfeng.compose.mydemo.ui.theme.MyDemoTheme

class MainActivity : AppCompatActivity() {
    val viewModel: WeViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {

            MyDemoTheme(viewModel.theme) {
                Box {
                    Home()
                    ChatPage()
                }

            }
        }
    }

    override fun onBackPressed() {
        if(viewModel.chatting){
            viewModel.endChat()
        } else{
            super.onBackPressed()
        }

    }



}
