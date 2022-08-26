package com.selftutor.mvvmnavigation.navigation

import androidx.annotation.StringRes
import com.selftutor.mvvmnavigation.base.BaseScreen

interface Navigator {
	fun launch(screen : BaseScreen)

	fun goBack(result: Any? = null)

	fun toast(@StringRes messageRes : Int)

	fun getString(@StringRes messageRes: Int): String
}