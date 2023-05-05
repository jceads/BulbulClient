package com.bulbul.bulbulclient.feature.presentation.viewModels

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bulbul.bulbulclient.core.util.Resource
import com.bulbul.bulbulclient.feature.domain.repository.PostRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
	private var repo : PostRepository
) : ViewModel() {
	private val TAG = "Home view model"
	fun getData(){
		viewModelScope.launch(Dispatchers.IO) {
			repo.getUsersPosts("b073ed42-131c-43a7-8b9b-904633fa140a",null,5)
				.collectLatest {
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