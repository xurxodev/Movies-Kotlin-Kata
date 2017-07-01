package com.xurxodev.movieskotlinkata.view

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.Toast
import com.squareup.picasso.Picasso
import java.io.Console

fun Context.toast(text: CharSequence, length: Int = Toast.LENGTH_SHORT) {
    Toast.makeText(this, text, length).show()
}

fun ViewGroup.inflate(layoutRes: Int): View {
    return LayoutInflater.from(this.context).inflate(layoutRes, this, false)
}

fun ImageView.loadUrl (url:String){
    try {
        Picasso.with(this.context).setLoggingEnabled(true)
        Picasso.with(this.context).load(url).into(this)
    }
    catch (e: Exception){
        Picasso.with(this.context).setLoggingEnabled(true)
    }
}
