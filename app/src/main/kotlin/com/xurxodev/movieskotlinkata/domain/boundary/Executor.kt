package com.xurxodev.movieskotlinkata.domain.boundary

interface Executor {
    fun uiExecute(uiFun:suspend ()->Unit)
    fun asyncExecute(asyncFun:suspend()->Unit)
}