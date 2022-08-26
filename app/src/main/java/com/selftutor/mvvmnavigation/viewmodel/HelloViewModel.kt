package com.selftutor.mvvmnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selftutor.mvvmnavigation.navigation.Navigator
import com.selftutor.mvvmnavigation.R
import com.selftutor.mvvmnavigation.base.BaseViewModel
import com.selftutor.mvvmnavigation.view.EditFragment
import com.selftutor.mvvmnavigation.view.HelloFragment

class HelloViewModel(
	private val navigator: Navigator,
	screen: HelloFragment.Screen
): BaseViewModel() {

	private val _currentMessageLiveData = MutableLiveData<String>()
	val currentMessageLiveData : LiveData<String> = _currentMessageLiveData

	init{
		_currentMessageLiveData.value = navigator.getString(R.string.hello_world)
	}

	fun onEditPressed(){
		navigator.launch(EditFragment.Screen(initialValue = currentMessageLiveData.value!!))
	}

	override fun onResult(result: Any) {
		if(result is String){
			_currentMessageLiveData.value = result
		}
	}
}