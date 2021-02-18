package top.zcwfeng.compose.mydemo.ui

import androidx.annotation.DrawableRes
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import top.zcwfeng.compose.mydemo.R
import top.zcwfeng.compose.mydemo.WeViewModel
import top.zcwfeng.compose.mydemo.ui.theme.MyDemoTheme
import top.zcwfeng.compose.mydemo.ui.theme.WeTheme

@Composable
fun WeBottomBar(selected: Int) {
    val viewModel: WeViewModel = viewModel()
    Row(Modifier.background(WeTheme.colors.bottomBar)) {
        TabItem(if (selected == 0) R.drawable.ic_chat_filled else R.drawable.ic_chat_outlined,
                "聊天",
                if (selected == 0) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
                Modifier
                        .clickable {
                            viewModel.selectedTab = 0
                        }
                        .weight(1f))
        TabItem(if (selected == 1) R.drawable.ic_contacts_filled else R.drawable.ic_contacts_outlined,
                "通讯录",
                if (selected == 1) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
                Modifier
                        .clickable {
                            viewModel.selectedTab = 1
                        }
                        .weight(1f))
        TabItem(if (selected == 2) R.drawable.ic_discover_filled else R.drawable.ic_discover_outlined,
                "发现",
                if (selected == 2) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
                Modifier
                        .clickable {
                            viewModel.selectedTab = 2
                        }
                        .weight(1f))
        TabItem(if (selected == 3) R.drawable.ic_me_filled else R.drawable.ic_me_outlined,
                "我",
                if (selected == 3) WeTheme.colors.iconCurrent else WeTheme.colors.icon,
                Modifier
                        .clickable {
                            viewModel.selectedTab = 3
                        }
                        .weight(1f))

    }
}

@Composable
private fun TabItem(@DrawableRes iconId: Int, title: String, color: Color, modifier: Modifier = Modifier) {
    Column(modifier.padding(vertical = 8.dp), horizontalAlignment = Alignment.CenterHorizontally)
    {
        Icon(vectorResource(iconId), title,Modifier/*.unread(true)*/.size(24.dp), tint = color)
        Text(title, fontSize = 11.sp, color = color)
    }
}


@Preview(showBackground = true)
@Composable
fun TabItemPreview() {
    TabItem(iconId = R.drawable.ic_chat_filled, title = "我的", WeTheme.colors.icon)
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreView() {
    MyDemoTheme {
        WeBottomBar(selected = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreViewDark() {
    MyDemoTheme(WeTheme.Theme.Dark) {
        WeBottomBar(selected = 0)
    }
}

@Preview(showBackground = true)
@Composable
fun WeBottomBarPreViewNewYear() {
    MyDemoTheme(WeTheme.Theme.NewYear) {
        WeBottomBar(selected = 1)
    }
}