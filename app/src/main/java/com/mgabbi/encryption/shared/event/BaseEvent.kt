package com.mgabbi.encryption.shared.event

interface BaseEvent

fun <EVENT : BaseEvent> EVENT.wrap() = EventWrapper(this)
