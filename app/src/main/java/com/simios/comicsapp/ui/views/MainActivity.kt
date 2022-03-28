package com.simios.comicsapp.ui.views

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import android.widget.Toast
import androidx.activity.viewModels
import com.simios.comicsapp.R
import com.simios.comicsapp.databinding.ActivityMainBinding
import com.simios.comicsapp.ui.viewmodels.ComicsViewModel
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.simios.comicsapp.data.model.Comic
import com.simios.comicsapp.ui.adapters.ComicsListAdapter
import com.simios.comicsapp.utils.Resource
import com.squareup.picasso.Picasso

class MainActivity : AppCompatActivity() {
    val TAG ="MainActivity"

    private lateinit var binding: ActivityMainBinding

    private val comicsViewModel: ComicsViewModel by viewModels()
    private  val comics = mutableListOf<Comic>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        comicsViewModel.loadCurrentComic()
        loadCurrentComic()
        loadLastedComics()
        initRecyclerView()
    }

    private fun loadCurrentComic(){
        comicsViewModel.currentComic.observe(this, Observer { response ->
            when(response) {
                is Resource.Success -> {
                    response.data?.let {comic ->
                        binding.safeTitle.text = comic.safeTitle
                        Picasso.get().load(comic.img).into(binding.currentComicImage)
                        comicsViewModel.loadAfterComic(comic.num)
                        binding.currentComicImage.setOnClickListener {onItemSelected(comic)}
                    }
                }
                is Resource.Error -> {
                    Toast.makeText(this, "Login Failed", Toast.LENGTH_SHORT).show()
                    response.message?.let { message ->
                        Log.e(TAG, "An error occured: $message")
                    }
                }
                is Resource.Loading -> {
                }
            }
        })
    }

    private fun loadLastedComics(){
        comicsViewModel.lastedComics.observe(this, Observer { response ->
            comics.add(response)
        })
    }

    private fun  initRecyclerView() = with((binding.comicsList)){
        layoutManager = LinearLayoutManager(context)
        adapter = ComicsListAdapter(comics) {onItemSelected(it)}
    }

    fun onItemSelected(comic :Comic){
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