package com.selftutor.mvvmnavigation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selftutor.mvvmnavigation.base.BaseFragment
import com.selftutor.mvvmnavigation.base.BaseScreen
import com.selftutor.mvvmnavigation.base.BaseViewModel
import com.selftutor.mvvmnavigation.base.screenViewModel
import com.selftutor.mvvmnavigation.databinding.FragmentHelloBinding
import com.selftutor.mvvmnavigation.viewmodel.HelloViewModel
import java.util.*

class HelloFragment: BaseFragment(){

	class Screen: BaseScreen{
	}

	override val viewModel by screenViewModel<HelloViewModel>()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		val binding = FragmentHelloBinding.inflate(inflater, container, false)

		binding.btnEdit.setOnClickListener{ viewModel.onEditPressed()}

		viewModel.currentMessageLiveData.observe(viewLifecycleOwner){
			binding.tvMain.text = it
		}

		return binding.root
	}
}