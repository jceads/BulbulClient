package com.bulbul.bulbulclient.feature.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bulbul.bulbulclient.R
import com.bulbul.bulbulclient.databinding.FragmentHomePageBinding
import com.bulbul.bulbulclient.feature.presentation.viewModels.HomeViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomePage : Fragment(R.layout.fragment_home_page) {
	private lateinit var binding: FragmentHomePageBinding
	private val viewModel : HomeViewModel by viewModels()

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentHomePageBinding.inflate(inflater,container,false)
		return binding.root
	}

	override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//		viewModel.getData()
		binding.getDataBtn.setOnClickListener {
			viewModel.getById("08db3ed2-fdbf-4206-87a2-7650aa121b0a")
		}
		super.onViewCreated(view, savedInstanceState)
	}
}