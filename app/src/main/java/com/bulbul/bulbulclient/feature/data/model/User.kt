package com.bulbul.bulbulclient.feature.data.model

data class User(
    val followedCount: Int,
    val followerCount: Int,
    val id: String,
    val info: String,
    val name: String,
    val show_Name: String
)