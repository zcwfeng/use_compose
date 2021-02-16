package top.zcwfeng.compose.mydemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import com.rengwuxian.wecompose.data.Chat
import com.rengwuxian.wecompose.data.Msg
import com.rengwuxian.wecompose.data.User
import top.zcwfeng.compose.mydemo.R
import top.zcwfeng.compose.mydemo.WeViewModel
import top.zcwfeng.compose.mydemo.ui.theme.MyDemoTheme
import top.zcwfeng.compose.mydemo.ui.theme.WeTheme
import top.zcwfeng.compose.mydemo.unread

@Composable
fun ChatListTopBar() {
    WeTopBar(title = "zcwfeng之信")
}


@Composable
fun ChatList(viewModel: WeViewModel = viewModel()) {
    Column(Modifier.fillMaxSize()) {
        ChatListTopBar()
        Box(
            Modifier
                .background(WeTheme.colors.background)
                .fillMaxSize()
        ) {
            ChatList(chats = viewModel.chats)
        }
    }
}

@Composable
fun ChatList(chats: List<Chat>) {
    Column(Modifier.background(WeTheme.colors.background)) {
        LazyColumn(
            Modifier
                .background(WeTheme.colors.listItem)
                .fillMaxSize()
        ) {
            itemsIndexed(chats) { index, chat ->
                ChatListItem(chat)
                if (index < chats.size - 1) {
                    Divider(
                        startIndent = 68.dp,
                        color = WeTheme.colors.chatListDivider,
                        thickness = 0.8f.dp
                    )
                }
            }
        }
    }
}

@Composable
private fun ChatListItem(
    chat: Chat,
    modifier: Modifier = Modifier,
    viewModel: WeViewModel = viewModel()
) {
    Row(
        Modifier
            .clickable {
                viewModel.startChat(chat)
            }
            .fillMaxWidth()
    ) {
        Image(
            vectorResource(id = chat.friend.avatar),
            contentDescription = chat.friend.name,/*"avatar"*/
            Modifier
                .size(48.dp)
                .padding(12.dp, 8.dp, 8.dp, 8.dp)
                .unread(!chat.msgs.last().read, WeTheme.colors.badge)
                .clip(RoundedCornerShape(4.dp))
        )

        Column(
            Modifier
                .weight(1f)
                .align(Alignment.CenterVertically)
        ) {
            Text(chat.friend.name, fontSize = 17.sp, color = WeTheme.colors.textPrimary)
            Text(
                chat.msgs.last().text,
                fontSize = 14.sp,
                color = WeTheme.colors.textSecondary
            )
        }
//                Text(
//                    chat.msgs.last().time,
//                    Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
//                    fontSize = 11.sp, color = WeTheme.colors.textSecondary
//                )
// TODO: 2021/2/16 chat.msgs.last().time <---13:48
        Text(
            "13:48",
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeTheme.colors.textSecondary
        )
    }
}




@Preview(showBackground = true)
@Composable
fun ChatListItemPreview() {
    MyDemoTheme {
        Box {
            ChatListItem(
                Chat(
                    friend = User("zcwfeng", "起灵老师", R.drawable.avatar_1),
                    mutableListOf(Msg(User("zcwfeng", "起灵老师", R.drawable.avatar_1), "哈哈"))
                ),
            )
        }
    }
}