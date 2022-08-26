package com.selftutor.mvvmnavigation.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.selftutor.mvvmnavigation.Event
import com.selftutor.mvvmnavigation.R
import com.selftutor.mvvmnavigation.base.BaseViewModel
import com.selftutor.mvvmnavigation.navigation.Navigator
import com.selftutor.mvvmnavigation.view.EditFragment

class EditViewModel(
	private val navigator: Navigator,
	screen: EditFragment.Screen
) : BaseViewModel() {

	private val _initialMessageEvent = MutableLiveData<Event<String>>()
	val initialMessageEvent: LiveData<Event<String>> = _initialMessageEvent

	init {
		_initialMessageEvent.value = Event(screen.initialValue)
	}

	fun onSavePressed(message: String) {
		if (message.isBlank()){
			navigator.toast(R.string.field_not_empty)
			return
		}

		navigator.goBack(message)
	}

	fun onCancelPressed() {
		navigator.goBack()
	}
}