package top.zcwfeng.compose.mydemo.ui

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.viewinterop.viewModel
import com.rengwuxian.wecompose.data.Chat
import top.zcwfeng.compose.mydemo.WeViewModel
import top.zcwfeng.compose.mydemo.ui.theme.WeTheme

@Composable
fun ChatList(chats: List<Chat>) {
    Column (Modifier.background(WeTheme.colors.background)) {
        WeTopBar(title = "zcwfeng信")
        LazyColumn(
            Modifier
                .background(WeTheme.colors.listItem)
                .fillMaxSize()) {
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
private fun ChatListItem(chat: Chat) {
    var viewModel:WeViewModel = viewModel()
    Row(
        Modifier
            .clickable {
                viewModel.startChat(chat)
            }
            .fillMaxWidth()
    ) {
        Image(
            imageVector = vectorResource(id = chat.friend.avatar),
            contentDescription = chat.friend.name,
            Modifier
                .size(48.dp)
                .padding(8.dp)
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

        Text(
            "13:48",
            Modifier.padding(8.dp, 8.dp, 12.dp, 8.dp),
            fontSize = 11.sp, color = WeTheme.colors.textSecondary
        )
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