package com.selftutor.mvvmnavigation

class Event<T>(
	private val value: T
) {
	private var handled = false

	fun getValue(): T? {
		if (handled) return null

		handled = true
		return value
	}
}