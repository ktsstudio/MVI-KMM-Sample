package ru.kts.mobile.sample.common

internal sealed interface Response<out T> {

    data class Success<out R>(val data: R) : Response<R>

    data class Failed(val throwable: Throwable) : Response<Nothing>
}
