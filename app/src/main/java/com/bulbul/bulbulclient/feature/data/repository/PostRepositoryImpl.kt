package com.bulbul.bulbulclient.feature.data.repository

import com.bulbul.bulbulclient.core.util.Resource
import com.bulbul.bulbulclient.feature.data.model.Bulbul
import com.bulbul.bulbulclient.feature.data.remote.PostService
import com.bulbul.bulbulclient.feature.domain.repository.PostRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import retrofit2.HttpException
import java.io.IOException
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
	private var api: PostService
) : PostRepository {
	override fun getUsersPosts(
		userId: String,
		step: Int?,
		limit: Int
	): Flow<Resource<List<Bulbul>>> = flow{
		emit(Resource.Loading())
		try {
			val response = api.getUsersPosts(userId,step,limit)
			emit(Resource.Succes(response))

		}catch (e:HttpException){
			emit(Resource.Error(e.message()))
		}catch (e:IOException){
			emit(Resource.Error(e.message))
		}
	}

}