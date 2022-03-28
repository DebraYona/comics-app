package com.simios.comicsapp.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simios.comicsapp.databinding.ActivityDetailComicBinding
import com.squareup.picasso.Picasso

class DetailComicActivity : AppCompatActivity() {
    val TAG = "DetailComicActivity"
    private lateinit var binding: ActivityDetailComicBinding
    var title: String? = null
    var date: String? = null
    var image: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailComicBinding.inflate(layoutInflater)
        setContentView(binding.root)
        getData()
        setupUi()
    }

    private fun getData() {
        if (intent.hasExtra("title") && intent.hasExtra("image") &&
            intent.hasExtra("date")
        ) {
            title = intent.getStringExtra("title")
            image = intent.getStringExtra("image")
            date = intent.getStringExtra("date")
        } else Toast.makeText(this, "No Data.", Toast.LENGTH_LONG).show()
    }

    private fun setupUi() {
        binding.comicTitle.text = title
        Picasso.get().load(image).into(binding.comicImage)
    }
}