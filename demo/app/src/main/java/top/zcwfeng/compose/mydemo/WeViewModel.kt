package top.zcwfeng.compose.mydemo

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.rengwuxian.wecompose.data.Chat
import com.rengwuxian.wecompose.data.Module
import com.rengwuxian.wecompose.data.Msg
import com.rengwuxian.wecompose.data.User
import top.zcwfeng.compose.mydemo.ui.theme.WeTheme

class WeViewModel : ViewModel() {

    var chats by mutableStateOf(
        listOf(
            Chat(
                friend = User("zcwfeng", "起灵老师", R.drawable.avatar_gaolaoshi),
                mutableStateListOf(
                    Msg(User("zcwfeng", "起灵老师", R.drawable.avatar_gaolaoshi), "锄禾日当午"),
                    Msg(User.Me, "汗滴禾下土"),
                    Msg(User("zcwfeng", "起灵老师", R.drawable.avatar_gaolaoshi), "谁知盘中餐"),
                    Msg(User.Me, "粒粒皆辛苦"),
                    Msg(
                        User("zcwfeng", "起灵老师", R.drawable.avatar_gaolaoshi),
                        "唧唧复唧唧，木兰当户织。不闻机杼声，惟闻女叹息。"
                    ),
                    Msg(User.Me, "双兔傍地走，安能辨我是雄雌？"),
                    Msg(User("zcwfeng", "起灵老师", R.drawable.avatar_gaolaoshi), "床前明月光，疑是地上霜。"),
                    Msg(User.Me, "吃饭吧？"),
                )
            ),
            Chat(
                friend = User("diuwuxian", "伽马射线", R.drawable.avatar_diuwuxian),
                mutableStateListOf(
                    Msg(User("diuwuxian", "伽马射线", R.drawable.avatar_diuwuxian), "哈哈哈"),
                    Msg(User.Me, "你笑个屁呀"),
                )
            ),
        )
    )
    val contacts by mutableStateOf(
        listOf(
            User("zcwfeng", "起灵老师", R.drawable.avatar_gaolaoshi),
            User("diuwuxian", "伽马射线", R.drawable.avatar_diuwuxian)
        )
    )
    var selectedTab by mutableStateOf(0)
    var currentChat: Chat? by mutableStateOf(null)
    var theme by mutableStateOf(WeTheme.Theme.Light)
    var chatting by mutableStateOf(false)
    var openModule: Module? by mutableStateOf(null)


    fun startChat(
        chat: Chat
    ) {
        currentChat = chat
        openModule = Module.Chat
    }

    fun endChat() {
        openModule = null
    }

    fun boom(chat: Chat) {
        chat.msgs.add(Msg(User.Me, "\uD83D\uDCA3").apply { read = true })
    }

    fun read(chat: Chat) {
        for (msg in chat.msgs) {
            msg.read = true
        }

    }
}