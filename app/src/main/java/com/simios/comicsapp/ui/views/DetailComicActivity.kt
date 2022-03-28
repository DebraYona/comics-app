package com.simios.comicsapp.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.simios.comicsapp.databinding.ActivityDetailComicBinding
import com.simios.comicsapp.databinding.ActivityMainBinding
import com.squareup.picasso.Picasso

class DetailComicActivity: AppCompatActivity() {
    val TAG ="DetailComicActivity"

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
    private fun  getData(){
        if (getIntent().hasExtra("title") && getIntent().hasExtra("image") &&
            getIntent().hasExtra("date")) {
            title = getIntent().getStringExtra("title")
            image = getIntent().getStringExtra("image")
            date = getIntent().getStringExtra("date")
        }else Toast.makeText(this, "No Data.", Toast.LENGTH_LONG).show()

    }

    private fun setupUi() {
        binding.comicTitle.text = title
        Picasso.get().load(image).into(binding.comicImage)

    }
}