package com.rengwuxian.wecompose.data

import androidx.annotation.DrawableRes
import top.zcwfeng.compose.mydemo.R

data class User(
  val id: String,
  val name: String,
  @DrawableRes val avatar: Int
) {
  companion object {
    val Me: User = User("David", "zcwfeng", R.drawable.avatar_rengwuxian)
  }
}