package com.selftutor.mvvmnavigation.navigation

import com.selftutor.mvvmnavigation.MainActivity

typealias MainActivityAction = (MainActivity) -> Unit

class MainActivityActions {

	var mainActivity: MainActivity? = null
		set(value) {
			field = value
			if (value != null) {
				actions.forEach { it(value) }
				actions.clear()
			}
		}

	private val actions = mutableListOf<MainActivityAction>()

	operator fun invoke(action: MainActivityAction){
		val activity = mainActivity
		if(activity == null)
			actions+=action
		else
			action(activity)
	}

	fun clear(){
		actions.clear()
	}
}