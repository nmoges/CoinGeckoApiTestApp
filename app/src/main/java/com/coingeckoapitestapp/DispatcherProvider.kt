package com.coingeckoapitestapp

import kotlinx.coroutines.Dispatchers
import kotlin.coroutines.CoroutineContext

interface DispatcherProvider {
    val default: CoroutineContext
    val main: CoroutineContext
    val io: CoroutineContext
}

class DispatcherProviderAndroid : DispatcherProvider {

    override val default: CoroutineContext
        get() = Dispatchers.Default
    override val main: CoroutineContext
        get() = Dispatchers.Main
    override val io: CoroutineContext
        get() = Dispatchers.IO

}

