package com.bulbul.bulbulclient.feature.data.model

data class Bulbul(
    val childPostId: String,
    val createTime: String,
    val id: String,
    val likeCount: Int,
    val parentPostId: String,
    val rePostCount: Int,
    val textContext: String,
    val user: User,
    val userId: String
)