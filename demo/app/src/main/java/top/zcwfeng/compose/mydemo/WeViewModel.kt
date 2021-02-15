package top.zcwfeng.compose.mydemo

import androidx.compose.runtime.*
import androidx.lifecycle.ViewModel
import com.rengwuxian.wecompose.data.Chat
import com.rengwuxian.wecompose.data.Msg
import com.rengwuxian.wecompose.data.User
import top.zcwfeng.compose.mydemo.ui.theme.WeTheme

class WeViewModel : ViewModel() {

    var chats by mutableStateOf(
        listOf(
            Chat(
                friend = User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                mutableStateListOf(
                    Msg(User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi), "锄禾日当午"),
                    Msg(User.Me, "汗滴禾下土"),
                    Msg(User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi), "谁知盘中餐"),
                    Msg(User.Me, "粒粒皆辛苦"),
                    Msg(
                        User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
                        "唧唧复唧唧，木兰当户织。不闻机杼声，惟闻女叹息。"
                    ),
                    Msg(User.Me, "双兔傍地走，安能辨我是雄雌？"),
                    Msg(User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi), "床前明月光，疑是地上霜。"),
                    Msg(User.Me, "吃饭吧？"),
                )
            ),
            Chat(
                friend = User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian),
                mutableStateListOf(
                    Msg(User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian), "哈哈哈"),
                    Msg(User.Me, "你笑个屁呀"),
                )
            ),
        )
    )
    val contacts by mutableStateOf(
        listOf(
            User("gaolaoshi", "高老师", R.drawable.avatar_gaolaoshi),
            User("diuwuxian", "丢物线", R.drawable.avatar_diuwuxian)
        )
    )
    var selectedTab by mutableStateOf(0)
    var currentChat: Chat? by mutableStateOf(null)
    var theme by mutableStateOf(WeTheme.Theme.Light)
    var chatting by mutableStateOf(false)


    fun startChat(
        chat: Chat
    ) {
        chatting = true
        currentChat = chat
    }

    fun endChat() {
        chatting = false
    }

}