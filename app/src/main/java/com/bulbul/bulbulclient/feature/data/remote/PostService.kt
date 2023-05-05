package com.bulbul.bulbulclient.feature.data.remote

import com.bulbul.bulbulclient.core.ClientEndpoints
import com.bulbul.bulbulclient.feature.data.model.Bulbul
import retrofit2.Response
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query


interface PostService {

	@GET("${ClientEndpoints.BULBULS}/user/{userId}")
	fun getUsersPosts(
		@Path("userId") userId:String,
		@Query("step") step:Int?,
		@Query("limit") limit:Int = 5
	):List<Bulbul>
}