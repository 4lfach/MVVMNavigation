package com.selftutor.mvvmnavigation.base

import androidx.fragment.app.Fragment

abstract class BaseFragment : Fragment() {

	abstract val viewModel : BaseViewModel
}