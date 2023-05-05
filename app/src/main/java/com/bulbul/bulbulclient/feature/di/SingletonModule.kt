package com.bulbul.bulbulclient.feature.di

import com.bulbul.bulbulclient.core.ClientEndpoints
import com.bulbul.bulbulclient.feature.data.remote.PostService
import com.bulbul.bulbulclient.feature.data.repository.PostRepositoryImpl
import com.bulbul.bulbulclient.feature.domain.repository.PostRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object SingletonModule {
	@Provides
	@Singleton
	fun providePostApi():PostService{
		return Retrofit.Builder()
			.baseUrl(ClientEndpoints.BASE_URL)
			.addConverterFactory(GsonConverterFactory.create())
			.build()
			.create()
	}

	@Provides
	@Singleton
	fun providePostRepo(api:PostService):PostRepository = PostRepositoryImpl(api)
}