package com.bulbul.bulbulclient.feature.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulbul.bulbulclient.core.util.Resource
import com.bulbul.bulbulclient.databinding.FragmentHomePageBinding
import com.bulbul.bulbulclient.feature.domain.repository.PostRepository
import com.bulbul.bulbulclient.feature.presentation.adapters.PostsAdapter
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private var repo : PostRepository
) : ViewModel() {
	private val TAG = "Home view model"
	fun getData(userId:String,binding: FragmentHomePageBinding){
		viewModelScope.launch(Dispatchers.IO) {
			repo.getUsersPosts(userId,null,5)
				.collectLatest {
						result->when(result){
					is Resource.Error -> Log.d(TAG,result.message?:"error")
					is Resource.Loading -> {}
					is Resource.Succes -> {
						Log.d(TAG, (result.data?:"null list").toString())
						withContext(Dispatchers.Main){

							result.data?.let {binding.homeRV.adapter =  PostsAdapter(it) }
						}
					}
				}
				}
		}
	}

	fun getById(bulbulId:String){
		viewModelScope.launch(Dispatchers.IO) {
			repo.getBulbulById(bulbulId).collectLatest {
					result->when(result){
				is Resource.Error -> Log.d(TAG,result.message?:"error")
				is Resource.Loading -> {}
				is Resource.Succes -> {
					Log.d(TAG, (result.data?:"null list").toString())

				}
			}
			}
		}
	}
}