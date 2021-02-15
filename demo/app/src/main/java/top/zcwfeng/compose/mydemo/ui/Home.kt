package top.zcwfeng.compose.mydemo.ui

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.AmbientAnimationClock
import androidx.compose.ui.viewinterop.viewModel
import top.zcwfeng.compose.mydemo.WeViewModel

@Composable
fun Home(){
    val viewModel:WeViewModel = viewModel()
    Column {
        val pagerState: PagerState = run {
            val clock = AmbientAnimationClock.current
            remember(clock) { PagerState(clock, maxPage = 3) }
        }
        Pager(state = pagerState, Modifier.weight(1f)) {
            when (page) {
                0 -> ChatList(viewModel.chats)
                1 -> Box(Modifier.fillMaxSize())
                2 -> Box(Modifier.fillMaxSize())
                3 -> Box(Modifier.fillMaxSize())
            }
        }
        WeBottomBar(selected = viewModel.selectedTab)
    }
}