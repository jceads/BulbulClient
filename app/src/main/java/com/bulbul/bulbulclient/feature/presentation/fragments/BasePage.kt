package com.bulbul.bulbulclient.feature.presentation.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bulbul.bulbulclient.R
import com.bulbul.bulbulclient.databinding.FragmentBasePageBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class BasePage : Fragment(R.layout.fragment_base_page) {
	private lateinit var binding : FragmentBasePageBinding

	override fun onCreateView(
		inflater: LayoutInflater, container: ViewGroup?,
		savedInstanceState: Bundle?
	): View {
		binding = FragmentBasePageBinding.inflate(inflater,container,false)
		return binding.root
	}

}