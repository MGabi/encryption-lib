package com.mgabbi.encryption.shared.utils

inline fun consume(toExecute: () -> Unit) = true.also { toExecute() }
