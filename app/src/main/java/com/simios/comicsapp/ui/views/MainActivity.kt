package com.simios.comicsapp.ui.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.simios.comicsapp.databinding.ActivityMainBinding
import com.simios.comicsapp.domain.model.Comic
import com.simios.comicsapp.ui.adapters.ComicsListAdapter
import com.simios.comicsapp.ui.viewmodels.ComicsViewModel
import com.squareup.picasso.Picasso
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    val TAG = "MainActivity"

    private lateinit var binding: ActivityMainBinding

    private val comicsViewModel: ComicsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        comicsViewModel.loadCurrentComic()
        loadCurrentComic()
        loadLastedComics()
    }

    private fun loadCurrentComic() {
        comicsViewModel.currentComic.observe(this, Observer { comic ->
            binding.safeTitle.text = comic.safeTitle
            Picasso.get().load(comic.img).into(binding.currentComicImage)
            comicsViewModel.loadAfterComic(comic.code)
            binding.currentComicImage.setOnClickListener { onItemSelected(comic) }

        })
    }

    private fun loadLastedComics() {
        comicsViewModel.lastedComics.observe(this, Observer { comics ->
            initRecyclerView(comics)
        })
    }

    private fun initRecyclerView(comics: List<Comic>) = with((binding.comicsList)) {
        layoutManager = LinearLayoutManager(context)
        adapter = ComicsListAdapter(comics) { onItemSelected(it) }
    }

    fun onItemSelected(comic: Comic) {
        Toast.makeText(this, comic.safeTitle, Toast.LENGTH_LONG).show()
        val date = "${comic.year}-${comic.month}-${comic.day} "
        val intent = Intent(this, DetailComicActivity::class.java).apply {
            putExtra("title", comic.safeTitle)
            putExtra("image", comic.img)
            putExtra("date", date)
        }
        startActivity(intent)
    }
}