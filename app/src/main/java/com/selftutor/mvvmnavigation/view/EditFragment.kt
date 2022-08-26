package com.selftutor.mvvmnavigation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.selftutor.mvvmnavigation.base.BaseFragment
import com.selftutor.mvvmnavigation.base.BaseScreen
import com.selftutor.mvvmnavigation.base.screenViewModel
import com.selftutor.mvvmnavigation.databinding.FragmentEditBinding
import com.selftutor.mvvmnavigation.viewmodel.EditViewModel

class EditFragment : BaseFragment() {

	class Screen(val initialValue: String) : BaseScreen {

	}

	override val viewModel: EditViewModel by screenViewModel()

	override fun onCreateView(
		inflater: LayoutInflater,
		container: ViewGroup?,
		savedInstanceState: Bundle?
	): View? {
		super.onCreate(savedInstanceState)
		val binding = FragmentEditBinding.inflate(inflater, container, false)

		viewModel.initialMessageEvent.observe(viewLifecycleOwner) {
			it.getValue().let { message -> binding.etValue.setText(message) }
		}

		binding.btnCancel.setOnClickListener { viewModel.onCancelPressed() }
		binding.btnSave.setOnClickListener { viewModel.onSavePressed(binding.etValue.text.toString()) }

		return binding.root
	}
}