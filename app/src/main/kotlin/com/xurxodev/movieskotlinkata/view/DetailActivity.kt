package com.xurxodev.movieskotlinkata.view

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.App
import com.xurxodev.movieskotlinkata.data.FakeMovieRepository
import kotlinx.android.synthetic.main.activity_detail.*
import javax.inject.Inject

class DetailActivity : AppCompatActivity() {

    companion object{
        val EXTRA_ID = "DetailActivity:id"
    }

    @Inject lateinit var movieRepository: FakeMovieRepository

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        (application as App).moviesComponent.inject(this)

        val id = intent.getLongExtra(EXTRA_ID, -1)

        val item = movieRepository.getById(id)

        if (item != null){
            item_image.loadUrl(item.url)
            item_title.text = item.title
        }
    }
}
