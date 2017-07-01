package com.xurxodev.movieskotlinkata.domain.usecase

import com.xurxodev.movieskotlinkata.domain.boundary.Executor

abstract class UseCase (private val executor: Executor){

    fun uiExecute(uiFun:suspend ()->Unit){
        executor.uiExecute{uiFun()}
    }
    fun asyncExecute(asyncFun:suspend()->Unit){
        executor.asyncExecute {asyncFun()}
    }

}