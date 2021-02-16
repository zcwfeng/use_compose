package top.zcwfeng.compose.mydemo.ui

import androidx.annotation.DrawableRes
import androidx.compose.animation.core.AnimationClockObservable
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableAmbient
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import top.zcwfeng.compose.mydemo.WeViewModel
import top.zcwfeng.compose.mydemo.ui.theme.WeTheme
import top.zcwfeng.compose.mydemo.R
import top.zcwfeng.compose.mydemo.percentOffsetX


@Composable
fun Home(AmbientAnimationClock: ProvidableAmbient<AnimationClockObservable>) {
    val viewModel: WeViewModel = viewModel()
    Box {
        Column {
            val pagerState: PagerState = run {
                val clock = AmbientAnimationClock.current
                remember(clock,viewModel.theme) { PagerState(clock, maxPage = 3) }
            }
            Pager(state = pagerState, Modifier.weight(1f)) {
                when (page) {
                    0 -> ChatList()
                    1 -> ContactList()
                    2 -> DiscoveryList()
                    3 -> MeList()
                }
            }
//        WeBottomBar(selected = viewModel.selectedTab)
            HomeBottomBar(pagerState.currentPage) {
                pagerState.currentPage = it
            }
        }
        val openOffset by animateFloatAsState(
            if (viewModel.openModule == null) {
                1f
            } else {
                0f
            }
        )
        if (viewModel.currentChat != null) {
            ChatPage(
                Modifier.percentOffsetX(openOffset),
                chat = viewModel.currentChat
            ) {
                viewModel.endChat()
            }
        }
    }
}


@Composable
fun HomeBottomBar(current: Int, currentChanged: (Int) -> Unit) {
    WeBottomBar {
        HomeBottomItem(
            Modifier
                .weight(1f)
                .clickable { currentChanged(0) },
            if (current == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
            "聊天",
            if (current == 0) WeTheme.colors.iconCurrent else WeTheme.colors.icon
        )
        HomeBottomItem(
            Modifier
                .weight(1f)
                .clickable { currentChanged(1) },
            if (current == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
            "通讯录",
            if (current == 1) WeTheme.colors.iconCurrent else WeTheme.colors.icon
        )
        HomeBottomItem(
            Modifier
                .weight(1f)
                .clickable { currentChanged(2) },
            if (current == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
            "发现",
            if (current == 2) WeTheme.colors.iconCurrent else WeTheme.colors.icon
        )
        HomeBottomItem(
            Modifier
                .weight(1f)
                .clickable { currentChanged(3) },
            if (current == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
            "我",
            if (current == 3) WeTheme.colors.iconCurrent else WeTheme.colors.icon
        )
    }
}


@Composable
fun HomeBottomItem(
    modifier: Modifier = Modifier,
    @DrawableRes iconId: Int,
    title: String,
    tint: Color
) {
    Column(
        modifier.padding(0.dp, 8.dp, 0.dp, 8.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(vectorResource(iconId), null, Modifier.size(24.dp), tint = tint)
        Text(title, fontSize = 11.sp, color = tint)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomPreview() {
    HomeBottomBar(0) {}
}