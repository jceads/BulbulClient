package com.bulbul.bulbulclient.feature.domain.repository

import com.bulbul.bulbulclient.core.util.Resource
import com.bulbul.bulbulclient.feature.data.model.Bulbul
import kotlinx.coroutines.flow.Flow
import retrofit2.Response

interface PostRepository {
	fun getUsersPosts(
		 userId:String,
		step:Int?,
		 limit:Int = 5
	): Flow<Resource<List<Bulbul>>>
}