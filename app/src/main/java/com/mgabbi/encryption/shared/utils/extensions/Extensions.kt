package com.mgabbi.encryption.shared.utils.extensions

import androidx.lifecycle.MutableLiveData
import com.mgabbi.encryption.BuildConfig
import java.util.regex.Pattern

val appVersion: String
    get() = "v${BuildConfig.VERSION_NAME}(${BuildConfig.VERSION_CODE})"

fun String.hasEmailPattern(): Boolean {
    val pattern = Pattern.compile(
        "[a-zA-Z0-9\\+\\.\\_\\%\\-\\+]{1,256}" +
                "\\@" +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,64}" +
                "(" +
                "\\." +
                "[a-zA-Z0-9][a-zA-Z0-9\\-]{0,25}" +
                ")+"
    )
    return pattern.matcher(this).matches()
}

operator fun MutableLiveData<Int>.minusAssign(t: Int) {
    val current = this.value ?: 0
    this.value = current - t
}

operator fun MutableLiveData<Int>.plusAssign(t: Int) {
    val current = this.value ?: 0
    this.value = current + t
}

fun <T : Any, R : Any> whenAllNotNull(vararg options: T?, block: (List<T>) -> R) {
    if (options.all { it != null }) {
        block(options.filterNotNull()) // or do unsafe cast to non null collection
    }
}

fun <T : Any, R : Any> whenAnyNotNull(vararg options: T?, block: (List<T>) -> R) {
    if (options.any { it != null }) {
        block(options.filterNotNull())
    }
}

inline fun <T : Any> guardLet(vararg elements: T?, closure: () -> Nothing): List<T> {
    return if (elements.all { it != null }) {
        elements.filterNotNull()
    } else {
        closure()
    }
}

inline fun guard(vararg elements: Boolean, closure: () -> Nothing) {
    if (!elements.all { it }) {
        closure()
    }
}

fun <T1 : Any, T2 : Any, R : Any> safeLet(p1: T1?, p2: T2?, block: (T1, T2) -> R?): R? {
    return if (p1 != null && p2 != null) block(p1, p2) else null
}

// Usage: condition then "yes" ?: "no"
infix fun <T> Boolean.then(param: T): T? = if (this) param else null
