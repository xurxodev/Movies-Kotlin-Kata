package com.xurxodev.movieskotlinkata.view

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.view.View
import com.xurxodev.moviesandroidkotlin.R
import com.xurxodev.movieskotlinkata.App
import com.xurxodev.movieskotlinkata.di.module.ActivityModule
import com.xurxodev.movieskotlinkata.model.Movie
import com.xurxodev.movieskotlinkata.presenter.MoviesDetailPresenter
import kotlinx.android.synthetic.main.activity_movie_detail.*
import javax.inject.Inject

class MovieDetailActivity : AppCompatActivity(),MoviesDetailPresenter.View {
    companion object {
        val EXTRA_ID = "MovieDetailActivity:id"

        fun newIntent(context: Context, id:Long): Intent {
            val intent = Intent(context, MovieDetailActivity::class.java)
            intent.putExtra(MovieDetailActivity.Companion.EXTRA_ID, id)

            return intent
        }
    }

    @Inject lateinit var presenter: MoviesDetailPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_detail)

        (application as App).appComponent.activityComponent()
                .activityModule(ActivityModule(this)).build().inject(this)

        val id = intent.getLongExtra(EXTRA_ID, -1)

        initializePresenter(id)
    }

    private fun initializePresenter(id: Long) {
        presenter.attachView(this,id)
    }

    override fun onDestroy() {
        presenter.detachView()
        super.onDestroy()
    }

    override fun showMovie(movie: Movie) {
        item_image.loadUrl(movie.url)
        item_title.text = movie.title
        item_overview_content.text = movie.overview
    }

    override fun showLoading() {
        movie_detail_container.visibility = View.GONE
        pb_loading.visibility = View.VISIBLE
    }

    override fun hideLoading() {
        pb_loading.visibility = View.GONE
        movie_detail_container.visibility = View.VISIBLE
    }
}
